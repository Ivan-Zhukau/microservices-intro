package com.ms.intro.resources;

import com.ms.intro.integration.songs.SongDataDto;
import com.ms.intro.integration.songs.SongDataParserService;
import com.ms.intro.integration.songs.SongServiceClient;

import lombok.AllArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class ResourcesService {
    private final ResourcesRepo repo;
    private final SongServiceClient songMsClient;
    private final SongDataParserService dataParcerService;

    public ResourceDomain saveResource(byte[] bytes) {
        ResourceDomain savedRes = repo.save(new ResourceDomain(bytes));
        try{
            SongDataDto dataDto = dataParcerService.getSongData(bytes);
            dataDto.setResourceId(savedRes.getId());
            songMsClient.saveSongMetadata(dataDto);
        } catch (Exception e) {
            System.out.println("ERROR while retrieving and sending metadata: " + e.getMessage());
        }
        return savedRes;
    }

    public ByteArrayResource getResource(Integer id) {
        ResourceDomain resource = repo.findById(id)
                .orElseThrow(() -> new FileNotExistException("The resource with the specified id does not exist!"));
        return new ByteArrayResource(resource.getBlob());
    }

    public List<Integer> deleteResources(Stream<ResourceDomain> resources){
        List<Integer> removedIds = delete(resources).mapToObj(Integer::valueOf).toList();
        try {
            songMsClient.deleteSongsMetadata(removedIds);
        } catch(Exception e) {
            // hide
        }
        return removedIds;
    }

    private IntStream delete(Stream<ResourceDomain> resources) {
        return resources.map(this::deleteResource)
                .filter(Objects::nonNull)
                .mapToInt(ResourceDomain::getId);
    }

    private ResourceDomain deleteResource(ResourceDomain res) {
        repo.deleteById(res.getId());
        return res;
    }

}

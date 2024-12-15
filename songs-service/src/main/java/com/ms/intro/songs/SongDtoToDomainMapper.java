package com.ms.intro.songs;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SongDtoToDomainMapper {
    SongDtoToDomainMapper INSTANCE = Mappers.getMapper( SongDtoToDomainMapper.class );
    SongData songToCarDto(SongDto dto);
    SongDto songToCarDto(SongData dto);

}

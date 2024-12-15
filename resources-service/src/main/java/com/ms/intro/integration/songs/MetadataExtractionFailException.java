package com.ms.intro.integration.songs;

public class MetadataExtractionFailException extends RuntimeException {
    public MetadataExtractionFailException(Exception e) {
        super(e);
    }

    public MetadataExtractionFailException() {
    }
}

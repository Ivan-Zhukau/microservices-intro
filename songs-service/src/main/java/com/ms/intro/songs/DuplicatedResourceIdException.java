package com.ms.intro.songs;

/**
 * runtime exception that should be thrown if not a mp3 file was uploaded.
 */
public class DuplicatedResourceIdException extends RuntimeException {
    public DuplicatedResourceIdException(String errMsg){
        super(errMsg);
    }
}

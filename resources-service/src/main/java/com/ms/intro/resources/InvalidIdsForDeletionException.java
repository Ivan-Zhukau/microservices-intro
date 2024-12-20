package com.ms.intro.resources;

/**
 * Runtime exception that should be thrown if not a mp3 file was uploaded.
 */
public class InvalidIdsForDeletionException extends RuntimeException{
    public InvalidIdsForDeletionException(){
        super();
    }
    public InvalidIdsForDeletionException(String errMsg){
        super(errMsg);
    }
}

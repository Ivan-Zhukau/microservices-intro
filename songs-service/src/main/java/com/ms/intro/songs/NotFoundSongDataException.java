package com.ms.intro.songs;

public class NotFoundSongDataException extends RuntimeException {
    public NotFoundSongDataException(){
        super();
    }
    public NotFoundSongDataException(String errMsg){
        super(errMsg);
    }
}

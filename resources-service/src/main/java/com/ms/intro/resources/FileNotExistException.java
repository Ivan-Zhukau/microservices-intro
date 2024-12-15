package com.ms.intro.resources;

/**
 * runtime exception that should be thrown if not a mp3 file was uploaded.
 */
public class FileNotExistException extends RuntimeException{
    public FileNotExistException(){
        super();
    }
    public FileNotExistException(String errMsg){
        super(errMsg);
    }
}

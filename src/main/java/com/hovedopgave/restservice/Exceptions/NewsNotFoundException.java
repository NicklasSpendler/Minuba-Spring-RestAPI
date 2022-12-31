package com.hovedopgave.restservice.Exceptions;

public class NewsNotFoundException extends RuntimeException{
    public NewsNotFoundException(long id){
        super("Could not find news " + id);
    }
}

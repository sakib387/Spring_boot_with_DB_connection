package com.example.BlogSystem.exception;

public class BlogNotFoundException extends RuntimeException{
    public BlogNotFoundException(String message){
        super(message);
    }
}

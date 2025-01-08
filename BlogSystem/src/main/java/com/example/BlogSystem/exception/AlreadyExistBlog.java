package com.example.BlogSystem.exception;

public class AlreadyExistBlog extends RuntimeException {
    public AlreadyExistBlog(String message) {
        super(message);
    }
}

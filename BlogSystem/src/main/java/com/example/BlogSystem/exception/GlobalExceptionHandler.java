package com.example.BlogSystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({BlogNotFoundException.class})
    public ResponseEntity<Object> handleBookNotFoundException(BlogNotFoundException ex) {

        Map<String, Object> response = new HashMap<>();

        response.put("message", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler({AlreadyExistBlog.class})
    public ResponseEntity<Object> handleAlreadyExistBlog(AlreadyExistBlog ex) {

        Map<String, Object> response = new HashMap<>();

        response.put("message", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);

    }

    @ExceptionHandler
    public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

        Map<String, Object> response = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            response.put(fieldName, message);

        });
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

    }

}

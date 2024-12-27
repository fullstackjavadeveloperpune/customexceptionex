package com.fullstack.advice;

import com.fullstack.exception.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler
    public Map<String, String> handleCustomException(RecordNotFoundException exception){
        Map<String, String> errors = new HashMap<>();

        errors.put("{errors}: ", exception.getMessage());

        return errors;
    }
}

package com.microdonation.microdonation.exception;

public class ApiException extends RuntimeException {
    public ApiException(String message) {
        super(message);
    }
}
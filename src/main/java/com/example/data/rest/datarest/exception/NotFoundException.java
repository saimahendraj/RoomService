package com.example.data.rest.datarest.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super("Entity not found exception");
    }

    public NotFoundException(String value) {
        super(value + " not found exception");
    }
}

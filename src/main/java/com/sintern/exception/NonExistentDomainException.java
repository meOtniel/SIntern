package com.sintern.exception;

public class NonExistentDomainException extends RuntimeException {

    public NonExistentDomainException(String message) {
        super(message);
    }
}

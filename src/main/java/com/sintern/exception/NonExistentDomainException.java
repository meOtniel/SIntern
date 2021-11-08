package com.sintern.exception;

public class NonExistentDomainException extends RuntimeException {

    public NonExistentDomainException() {
    }

    public NonExistentDomainException(String message) {
        super(message);
    }
}

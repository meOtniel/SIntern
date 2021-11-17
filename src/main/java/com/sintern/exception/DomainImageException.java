package com.sintern.exception;

public class DomainImageException extends RuntimeException {
    public DomainImageException(Exception e) {
        super(e);
    }

    public DomainImageException(String message) {
        super(message);
    }
}

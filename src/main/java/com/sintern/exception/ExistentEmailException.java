package com.sintern.exception;

public class ExistentEmailException extends RuntimeException {

    public ExistentEmailException(Exception e) {
        super(e);
    }

    public ExistentEmailException(String message) {
        super(message);
    }
}
package com.sintern.exception;

public class ExistentEmailException extends RuntimeException {

    public ExistentEmailException(String message) {
        super(message);
    }
}
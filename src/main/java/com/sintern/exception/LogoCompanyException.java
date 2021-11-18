package com.sintern.exception;

public class LogoCompanyException extends RuntimeException {
    public LogoCompanyException(Exception e) {
        super(e);
    }

    public LogoCompanyException(String message) {
        super(message);
    }
}

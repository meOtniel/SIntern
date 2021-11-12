package com.sintern.api;

import com.sintern.exception.ApiError;
import com.sintern.exception.ExistentEmailException;
import com.sintern.exception.NonExistentDomainException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.time.ZonedDateTime;

@RestControllerAdvice
public class SInternExceptionHandler {

    @ExceptionHandler(value = {ExistentEmailException.class})
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    public ApiError handleExistentEmailException(ExistentEmailException exception) {
        return new ApiError(ZonedDateTime.now(), HttpStatus.UNAUTHORIZED, exception.getMessage());
    }

    @ExceptionHandler(value = {NonExistentDomainException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ApiError handleNonExistentDomainException(NonExistentDomainException exception) {
        return new ApiError(ZonedDateTime.now(), HttpStatus.NOT_FOUND, exception.getMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleConstraintViolationException(ConstraintViolationException exception) {
        return new ApiError(ZonedDateTime.now(), HttpStatus.UNAUTHORIZED, "Not valid due to validation error: " + exception.getMessage());
    }
}
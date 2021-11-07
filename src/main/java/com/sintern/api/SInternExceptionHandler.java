package com.sintern.api;

import com.sintern.exception.ApiError;
import com.sintern.exception.ExistentEmailException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZonedDateTime;
import java.util.List;

@RestControllerAdvice
public class SInternExceptionHandler {

    @ExceptionHandler(value = {ExistentEmailException.class})
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    public ApiError handleExistentEmailException(ExistentEmailException exception){
        return new ApiError(ZonedDateTime.now(), HttpStatus.UNAUTHORIZED, List.of("Email already exists"));
    }

}
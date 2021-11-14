package com.sintern.api;

import com.sintern.exception.ApiError;
import com.sintern.exception.ExistentEmailException;
import com.sintern.exception.NonExistentDomainException;
import com.sintern.exception.SaveCvFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

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

    @ExceptionHandler(value = {ConstraintViolationException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ApiError handleConstraintViolationException(ConstraintViolationException exception) {
        return new ApiError(ZonedDateTime.now(), HttpStatus.BAD_REQUEST, exception.getMessage());
    }

    @ExceptionHandler(value = {SaveCvFailedException.class})
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiError handleCouldNotSaveCvException(SaveCvFailedException exception) {
        return new ApiError(ZonedDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ApiError handleMaxSizeException(MaxUploadSizeExceededException exc) {
        return new ApiError(ZonedDateTime.now(), HttpStatus.BAD_REQUEST, "Unable to upload. File is too large!");
    }

}

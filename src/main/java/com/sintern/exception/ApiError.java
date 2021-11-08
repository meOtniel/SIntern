package com.sintern.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class ApiError {

    @JsonProperty(value = "timestamp", required = true)
    private ZonedDateTime timestamp;

    @JsonProperty(value = "status", required = true)
    private HttpStatus status;

    @JsonProperty(value = "message")
    private String errorMessage;

    public ApiError(ZonedDateTime timestamp, HttpStatus status, String errorMessage) {
        this.timestamp = timestamp;
        this.status = status;
        this.errorMessage = errorMessage;
    }
}
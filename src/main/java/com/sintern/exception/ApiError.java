package com.sintern.exception;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;
import java.time.ZonedDateTime;
import java.util.List;

public class ApiError {

    @JsonProperty(value = "timestamp", required = true)
    private ZonedDateTime timestamp;

    @JsonProperty(value = "status", required = true)
    private HttpStatus status;

    @JsonProperty(value = "messages")
    private List<String> errorMessages;

    public ApiError(ZonedDateTime timestamp, HttpStatus status, List<String> errorMessages) {
        this.timestamp = timestamp;
        this.status = status;
        this.errorMessages = errorMessages;
    }
}
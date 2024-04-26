package com.backend.traini8.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BusinessException extends RuntimeException {
    private final String description;
    private final HttpStatus httpStatus;

    /**
     * Constructor that accepts a message and HTTP status.
     *
     * @param description The detailed error message.
     * @param httpStatus The HTTP status code representing the type of error.
     */
    public BusinessException(String description, HttpStatus httpStatus) {
        super(description);
        this.description = description;
        this.httpStatus = httpStatus;
    }
}

package com.backend.traini8.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles validation exceptions that occur due to invalid input parameters.
     *
     * @param ex      The MethodArgumentNotValidException instance.
     * @param request The HttpServletRequest instance.
     * @return A ResponseEntity containing the error messages and HTTP status code.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex, HttpServletRequest request) {
        BindingResult bindingResult = ex.getBindingResult();
        Map<String, String> errors = new HashMap<>();

        // Iterate through each field error in the binding result
        for (FieldError error : bindingResult.getFieldErrors()) {
            // Add the field and its error message to the errors map
            errors.put(error.getField(), error.getDefaultMessage());
        }

        // Return a BAD_REQUEST response with the map of error messages
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles custom business exceptions that occur within the application.
     *
     * @param ex The BusinessException instance.
     * @param request The HttpServletRequest instance.
     * @return A ResponseEntity containing the description of the exception and HTTP status code.
     */
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<?> handleBusinessException(BusinessException ex, HttpServletRequest request) {
        // Return a response with the provided exception description and HTTP status
        return new ResponseEntity<>(ex.getDescription(), ex.getHttpStatus());
    }

    /**
     * Handles any other unknown exceptions that occur within the application.
     *
     * @param ex The Exception instance.
     * @param request The HttpServletRequest instance.
     * @return A ResponseEntity containing the exception message and HTTP status code.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleUnknownException(Exception ex, HttpServletRequest request) {
        // Return an INTERNAL_SERVER_ERROR response with the exception message
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

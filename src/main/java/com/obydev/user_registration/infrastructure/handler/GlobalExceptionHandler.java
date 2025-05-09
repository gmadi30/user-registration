package com.obydev.user_registration.infrastructure.handler;

import com.obydev.user_registration.application.exception.InvalidUserEmailException;
import com.obydev.user_registration.application.exception.InvalidUserPasswordException;
import com.obydev.user_registration.infrastructure.exception.ApiErrorResponse;
import com.obydev.user_registration.infrastructure.exception.UserAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidUserEmailException.class)
    public ResponseEntity<ApiErrorResponse> handleInvalidUserEmailException(InvalidUserEmailException e, WebRequest request) {
        ApiErrorResponse errorResponse = new ApiErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Bad request",
                e.getMessage(),
                request.getDescription(false));

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorResponse
                );
    }

    @ExceptionHandler(InvalidUserPasswordException.class)
    public ResponseEntity<ApiErrorResponse> handleInvalidUserPasswordException(InvalidUserPasswordException e, WebRequest request) {
        ApiErrorResponse errorResponse = new ApiErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Bad request",
                e.getMessage(),
                request.getContextPath()
        );


        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ApiErrorResponse> handleUserAlreadyExistsException(UserAlreadyExistsException e, WebRequest request) {
        ApiErrorResponse errorResponse = new ApiErrorResponse(
                HttpStatus.CONFLICT.value(),
                "Conflict",
                e.getMessage(),
                "architecture");

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(errorResponse);
    }
}

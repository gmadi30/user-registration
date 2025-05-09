package com.obydev.user_registration.application.exception;

public class InvalidUserEmailException extends RuntimeException{
    public InvalidUserEmailException(String message) {
        super(message);
    }
}

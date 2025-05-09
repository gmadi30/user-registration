package com.obydev.user_registration.application.exception;

public class InvalidUserPasswordException extends RuntimeException{
    public InvalidUserPasswordException(String message) {
        super(message);
    }
}

package com.obydev.user_registration.infrastructure.dto;

public class UserRegistrationRequest {

    private final String email;
    private final String password;

    public UserRegistrationRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}

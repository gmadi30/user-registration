package com.obydev.user_registration.domain.models;

import java.util.UUID;

public class User {
    private final UUID id;
    private final String email;
    private final String password;

    public User(String email, String password) {
        this.id = UUID.randomUUID();
        this.email = email;
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}

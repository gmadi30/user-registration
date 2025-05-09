package com.obydev.user_registration.infrastructure.web;

import com.obydev.user_registration.application.register.RegisterUserUseCase;
import com.obydev.user_registration.infrastructure.dto.UserRegistrationRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final RegisterUserUseCase registerUserService;

    public UserController(RegisterUserUseCase registerUserService) {
        this.registerUserService = registerUserService;
    }

    @PostMapping
    public ResponseEntity<Void> registerUser(@Valid @RequestBody UserRegistrationRequest userRegistrationRequest) {
        registerUserService.registerUser(
                userRegistrationRequest.getEmail(),
                userRegistrationRequest.getPassword()
        );

        return ResponseEntity.ok().build();
    }
}

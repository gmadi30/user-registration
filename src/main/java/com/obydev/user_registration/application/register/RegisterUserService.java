package com.obydev.user_registration.application.register;

import com.obydev.user_registration.application.exception.InvalidUserEmailException;
import com.obydev.user_registration.application.exception.InvalidUserPasswordException;
import com.obydev.user_registration.domain.models.User;
import com.obydev.user_registration.domain.repository.UserRepository;

public class RegisterUserService implements RegisterUserUseCase {

    private final UserRepository userRepository;

    public RegisterUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(String email, String password) {

        if (emailValidation(email)) {
            throw new InvalidUserEmailException("Invalid email");
        }

        if (passwordValidation(password)) {
            throw new InvalidUserPasswordException("Invalid password");
        }

        userRepository.save(new User(email, password));
    }

    private boolean passwordValidation(String password) {
        return password == null || password.isEmpty();
    }

    private boolean emailValidation(String email) {
        return email == null || email.isEmpty();
    }
}

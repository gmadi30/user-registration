package com.obydev.user_registration.infrastructure.config;

import com.obydev.user_registration.application.register.RegisterUserService;
import com.obydev.user_registration.domain.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserBeanConfig {

    @Bean
    public RegisterUserService registerUserService (UserRepository userRepository){
        return new RegisterUserService(userRepository);
    }
}

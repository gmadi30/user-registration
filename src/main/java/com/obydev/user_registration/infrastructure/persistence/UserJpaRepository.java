package com.obydev.user_registration.infrastructure.persistence;

import com.obydev.user_registration.domain.models.User;
import com.obydev.user_registration.domain.repository.UserRepository;
import com.obydev.user_registration.infrastructure.exception.UserAlreadyExistsException;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserJpaRepository implements UserRepository {

    Map<String, User> userMap = new HashMap<>();

    @Override
    public void save(User user) {
        if (userMap.containsKey(user.getEmail())) {
           throw new UserAlreadyExistsException("User already exists");
        }

        userMap.put(user.getEmail(), user);
    }
}

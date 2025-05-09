package com.obydev.user_registration.domain.repository;

import com.obydev.user_registration.domain.models.User;

public interface UserRepository {

    void save(User user);
}

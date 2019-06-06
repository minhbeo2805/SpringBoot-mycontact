package com.demo.service;

import com.demo.domain.User;

import java.util.Optional;

public interface UserService {
    Optional<User> login(String username, String password);

    User save(User user);
 
    void delete(int id);
 
}
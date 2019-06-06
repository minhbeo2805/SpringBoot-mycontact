package com.demo.service;
import com.demo.domain.User;
import com.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> login(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }
    @Override
    public User save(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public void delete(int id) {
        userRepository.deleteById(id);
    }

}
package com.demo.repository;

import com.demo.domain.Contact;
import com.demo.domain.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByUsernameAndPassword (String username, String password);
}
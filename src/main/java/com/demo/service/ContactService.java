package com.demo.service;

import com.demo.domain.Contact;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

public interface ContactService {
 
    Iterable<Contact> findAll();

    Page<Contact> search(String name, String email, Pageable pageable);
 
    Optional<Contact> findOne(int id);
 
    Contact save(Contact contact);
 
    void delete(int id);
 
}
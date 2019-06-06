package com.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.demo.domain.Contact;


public interface ContactRepository extends CrudRepository<Contact, Integer> {

    Page<Contact> findByNameContainingAndEmailContaining (String name, String email, Pageable pageable);
 
}
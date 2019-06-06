package com.demo.service;

import com.demo.domain.Contact;
import com.demo.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
 
@Service
public class ContactServiceImpl implements ContactService {
 
    private ContactRepository contactRepository;
 
    @Autowired
    public void setContactRepository(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }
 
    @Override
    public Iterable<Contact> findAll() {
        return contactRepository.findAll();
    }
 
    @Override
    public Page<Contact> search(String name, String email, Pageable pageable) {
        return contactRepository.findByNameContainingAndEmailContaining(name, email, pageable);
    }
 
    @Override
    public Optional<Contact> findOne(int id) {
        return contactRepository.findById(id);
    }
 
    @Override
    public Contact save(Contact contact) {
        contactRepository.save(contact);
        System.out.println(contact.getName());
        return contact;
    }
 
    @Override
    public void delete(int id) {
        contactRepository.deleteById(id);
    }
 
}
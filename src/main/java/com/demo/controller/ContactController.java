package com.demo.controller;

import com.demo.domain.Contact;
import com.demo.domain.User;
import com.demo.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.awt.print.Pageable;
import java.util.Optional;

@RestController
public class ContactController {

	private ContactService contactService;

	@Autowired
	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}

	@GetMapping("/contact")
	@CrossOrigin
	public Iterable getAll() {
		return contactService.findAll();
	}

	@PutMapping("/contact")
	@CrossOrigin
	public Contact update(@RequestBody Contact contact) {
		return contactService.save(contact);
	}
	
	@PostMapping("/contact")
	@CrossOrigin
	public  Contact create(@RequestBody @Valid Contact contact) {
	    return contactService.save(contact);
	}
	
	@GetMapping("/contact/{id}")
	@CrossOrigin
	public Optional find(@PathVariable int id) {
	    return contactService.findOne(id);
	}

	@DeleteMapping("/contact/{id}")
	@CrossOrigin
	public void delete(@PathVariable int id) {
	    contactService.delete(id);
	 }

	@GetMapping("/contact/search")
	@CrossOrigin
	public Page<Contact> search(@RequestParam("searchName") String searchName, @RequestParam("searchEmail") String searchEmail, @RequestParam("page") int page) {
		PageRequest pageable = PageRequest.of(page - 1, 10);
		return contactService.search(searchName,searchEmail, pageable);
	}

}

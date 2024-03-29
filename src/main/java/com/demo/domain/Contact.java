package com.demo.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "contact")
public class Contact implements Serializable {
	 private static final long serialVersionUID = 1L;
	 
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id", updatable = false, nullable = false)
	    private int id;
	 
	    @NotEmpty(message="Please enter name")
	    @Column(name = "name", nullable = false)
	    private String name;
	 
	    @Email(message="Please enter valid email")
	    @Column(name = "email")
	    private String email;
	 
	    @Column(name = "phone")
	    private String phone;
	 
	    public Contact() {
	        super();
	    }
	 
	    public Contact(int id, String name, String email, String phone) {
	        super();
	        this.id = id;
	        this.name = name;
	        this.email = email;
	        this.phone = phone;
	    }
	 
	    public int getId() {
	        return id;
	    }
	 
	    public void setId(int id) {
	        this.id = id;
	    }
	 
	    public String getName() {
	        return name;
	    }
	 
	    public void setName(String name) {
	        this.name = name;
	    }
	 
	    public String getEmail() {
	        return email;
	    }
	 
	    public void setEmail(String email) {
	        this.email = email;
	    }
	 
	    public String getPhone() {
	        return phone;
	    }
	 
	    public void setPhone(String phone) {
	        this.phone = phone;
	    }
	 
}

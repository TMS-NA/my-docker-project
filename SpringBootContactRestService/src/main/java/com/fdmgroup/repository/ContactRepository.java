package com.fdmgroup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}

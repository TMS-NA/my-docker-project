package com.fdmgroup.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.model.Contact;
import com.fdmgroup.repository.ContactRepository;

@Service
public class ContactService {
	
	private ContactRepository contactRepo;
	@Autowired
	public ContactService(ContactRepository contactRepo) {
		super();
		this.contactRepo = contactRepo;
	}
	
	
	public List<Contact> getAllContacts(){
		return contactRepo.findAll();
	}
	public Contact getContact(long contactId) {
		Optional<Contact> contactOpt=contactRepo.findById(contactId);
		if(!contactOpt.isPresent()) {
			throw new ContactNotFound("The contact with id "+contactId+" is not found");
		}
		return contactOpt.get();
	}
	
	public Contact createContact(Contact contact) {
		return contactRepo.save(contact);
	}
	
	public Contact updateContact(Contact contact) {
		return contactRepo.save(contact);
	}
	public void deleetContactById(long contactId) {
		contactRepo.deleteById(contactId);
	}	
	
}

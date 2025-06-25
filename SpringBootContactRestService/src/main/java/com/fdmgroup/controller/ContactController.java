package com.fdmgroup.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fdmgroup.model.Contact;
import com.fdmgroup.service.ContactService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/v1/contacts")
public class ContactController {
	
	private ContactService contactService;
	@Autowired
	public ContactController(ContactService contactService) {
		super();
		this.contactService = contactService;
	}
	
	
	@GetMapping
	public ResponseEntity<List<Contact>> getContacts(){
		System.out.println("  Requested sent to SERVER 1 ");
		return ResponseEntity.ok(contactService.getAllContacts());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Contact> getContact(@PathVariable("id") long contactId){
		Contact foundContact = contactService.getContact(contactId);
//		URI responseLocation = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//								.buildAndExpand(foundContact.getContactId()).toUri();
//		return ResponseEntity.created(responseLocation).body(foundContact);
		return ResponseEntity.ok(foundContact);		
	}
	
	@PostMapping
	public ResponseEntity<Contact> createContact(@Valid @RequestBody Contact contact){
		Contact createdContact = contactService.createContact(contact);
		URI responseLocation = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createdContact.getContactId()).toUri();
		return ResponseEntity.created(responseLocation).body(createdContact);

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Contact> updateContact(@PathVariable long id, @RequestBody Contact contact ){
		Contact updatedContact = contactService.updateContact(contact);
		return ResponseEntity.ok(updatedContact);
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteContact(@PathVariable long id) {
		contactService.deleetContactById(id);
	}

	
	
	

}

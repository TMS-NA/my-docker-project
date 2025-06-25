package com.fdmgroup.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Contact {
	@Id
	@GeneratedValue
	private long contactId;
	@NotNull(message = "The firstname can not be NULL")
	private String firstname;
	private String lastname;
	private String phoneNumber;
	public Contact() {
		super();
	}
	public Contact(long contactId, String firstname, String lastname, String phoneNumber) {
		super();
		this.contactId = contactId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phoneNumber = phoneNumber;
	}
	public long getContactId() {
		return contactId;
	}
	public void setContactId(long contactId) {
		this.contactId = contactId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", phoneNumber=" + phoneNumber + "]";
	}
	
	
	
	

}

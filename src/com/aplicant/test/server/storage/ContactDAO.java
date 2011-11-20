package com.aplicant.test.server.storage;

import java.util.ArrayList;
import java.util.UUID;

import com.aplicant.test.shared.model.Contact;

public class ContactDAO {
	private ArrayList<Contact> data = new ArrayList<Contact>(); 
	
	private static ContactDAO instance = null;
	
	private ContactDAO(){
		Contact c = null;

		c = new Contact("User1", "+79223421334");
		addContact(c);
		
		c = new Contact("User2", "+79223421331");
		addContact(c);

		c = new Contact("User3", "+79223421322");
		addContact(c);
	}
	
	public static ContactDAO getInstance(){
		if(instance==null){
			instance = new ContactDAO();
		}
		
		return instance;
	}
	
	public ArrayList<Contact> getContacts(String nameFilter){
		return data;
	}
	
	public void addContact(Contact contact){
		contact.id = UUID.randomUUID().toString();
		data.add(contact);
	}
	
	public void updateContact(Contact contact){
	
	}
	
	public void deleteContact(Contact contact){
		
	}
}

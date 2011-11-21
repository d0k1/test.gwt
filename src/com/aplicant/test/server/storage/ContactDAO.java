package com.aplicant.test.server.storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import com.aplicant.test.shared.model.Contact;

public class ContactDAO {
	private HashMap<String, Contact> data = new HashMap<String, Contact>();
//	private ArrayList<Contact> data = new ArrayList<Contact>(); 
	
	private static ContactDAO instance = null;
	
	private ContactDAO(){
		Contact c = null;

		c = new Contact("First User", "+79223421334");
		addContact(c);
		
		c = new Contact("Second User", "+79223421331");
		addContact(c);

		c = new Contact("Third User", "+79223421322");
		addContact(c);
	}
	
	public static ContactDAO getInstance(){
		if(instance==null){
			instance = new ContactDAO();
		}
		
		return instance;
	}
	
	public ArrayList<Contact> getContacts(String nameFilter){
		ArrayList<Contact> result = new ArrayList<Contact>();
		
		for (Contact contact : data.values()) {
			if(contact.name.toLowerCase().startsWith(nameFilter.toLowerCase())){
				result.add(contact);
			}
		}
		return result;
	}
	
	public void addContact(Contact contact){
		contact.id = UUID.randomUUID().toString();
		data.put(contact.id, contact);
	}
	
	public Contact getContactById(String id) {
		return data.get(id);
	}
	
	public void updateContact(Contact contact) {
		data.put(contact.id, contact);
	}
	
	public void deleteContact(String id) {
		data.remove(id);
	}
}

package com.aplicant.test.shared.action.get;

import java.util.ArrayList;

import net.customware.gwt.dispatch.shared.Result;

import com.aplicant.test.shared.model.Contact;

public class GetContactsResult implements Result {
	
	private ArrayList<Contact> contacts = new ArrayList<Contact>();
	
	public GetContactsResult(){		
	}
	
	public void setContacts(ArrayList<Contact> data){
		contacts.clear();
		contacts.addAll(data);
	}
	
	public ArrayList<Contact> getContacts(){
		return contacts;
	}
}

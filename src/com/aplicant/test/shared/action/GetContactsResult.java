package com.aplicant.test.shared.action;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.aplicant.test.shared.model.Contact;
import com.google.gwt.user.client.rpc.IsSerializable;

import net.customware.gwt.dispatch.shared.Result;

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

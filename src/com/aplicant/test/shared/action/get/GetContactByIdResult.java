package com.aplicant.test.shared.action.get;

import com.aplicant.test.shared.model.Contact;

import net.customware.gwt.dispatch.shared.Result;

public class GetContactByIdResult implements Result {

	private Contact contact;

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}
	
}

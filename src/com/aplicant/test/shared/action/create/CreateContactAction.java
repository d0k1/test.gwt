package com.aplicant.test.shared.action.create;

import net.customware.gwt.dispatch.shared.Action;

import com.aplicant.test.shared.action.get.GetContactsResult;
import com.aplicant.test.shared.model.Contact;

public class CreateContactAction implements Action<CreateContactResult> {
	
	private Contact contact;

	public CreateContactAction(){
	}

	public CreateContactAction(Contact contact){
		this.contact = contact;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}
}

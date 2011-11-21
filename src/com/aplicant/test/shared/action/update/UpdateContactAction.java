package com.aplicant.test.shared.action.update;

import net.customware.gwt.dispatch.shared.Action;

import com.aplicant.test.shared.action.get.GetContactsResult;
import com.aplicant.test.shared.model.Contact;

public class UpdateContactAction implements Action<UpdateContactResult> {
	private Contact contact;

	public UpdateContactAction(){
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

}

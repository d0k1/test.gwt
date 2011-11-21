package com.aplicant.test.client.event.phonebook.delete;

import com.aplicant.test.shared.model.Contact;
import com.google.gwt.event.shared.GwtEvent;

public class DeleteContactEvent extends GwtEvent<DeleteContactHandler> {
	private Contact contact;
	
	public static Type<DeleteContactHandler> TYPE = new Type<DeleteContactHandler>();

	@Override
	public Type<DeleteContactHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(DeleteContactHandler handler) {
		handler.onDeleteContact(this);
	}
	
	public DeleteContactEvent(Contact contact){
		this.contact = contact;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}
}

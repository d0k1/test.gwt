package com.aplicant.test.client.event.phonebook.update;

import com.aplicant.test.shared.model.Contact;
import com.google.gwt.event.shared.GwtEvent;

public class UpdateContactEvent extends GwtEvent<UpdateContactHandler> {
	private Contact contact;
	
	public static Type<UpdateContactHandler> TYPE = new Type<UpdateContactHandler>();

	@Override
	public Type<UpdateContactHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(UpdateContactHandler handler) {
		handler.onUpdateContact(this);
	}
	
	public UpdateContactEvent(Contact contact){
		this.contact = contact;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}
}

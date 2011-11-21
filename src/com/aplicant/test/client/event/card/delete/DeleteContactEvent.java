package com.aplicant.test.client.event.card.delete;

import com.aplicant.test.shared.model.Contact;
import com.google.gwt.event.shared.GwtEvent;

public class DeleteContactEvent extends GwtEvent<DeleteContactHandler> {
	public static Type<DeleteContactHandler> TYPE = new Type<DeleteContactHandler>();

	private Contact contact;
	
	@Override
	public Type<DeleteContactHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(DeleteContactHandler handler) {
		handler.onDeleteContact(this);
	}

	public DeleteContactEvent(Contact contact) {
		super();
		this.contact = contact;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}
}

package com.aplicant.test.client.event.phonebook.create;

import com.google.gwt.event.shared.GwtEvent;

public class CreateContactEvent extends GwtEvent<CreateContactHandler> {
	public static Type<CreateContactHandler> TYPE = new Type<CreateContactHandler>();

	@Override
	public Type<CreateContactHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(CreateContactHandler handler) {
		handler.onCreateContact(this);
	}
}

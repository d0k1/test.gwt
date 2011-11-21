package com.aplicant.test.client.event.phonebook.update;

import com.google.gwt.event.shared.GwtEvent;

public class UpdateContactEvent extends GwtEvent<UpdateContactHandler> {
	public static Type<UpdateContactHandler> TYPE = new Type<UpdateContactHandler>();

	@Override
	public Type<UpdateContactHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(UpdateContactHandler handler) {
		handler.onUpdateContact(this);
	}
}

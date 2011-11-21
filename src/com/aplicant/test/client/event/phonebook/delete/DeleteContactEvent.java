package com.aplicant.test.client.event.phonebook.delete;

import com.google.gwt.event.shared.GwtEvent;

public class DeleteContactEvent extends GwtEvent<DeleteContactHandler> {
	public static Type<DeleteContactHandler> TYPE = new Type<DeleteContactHandler>();

	@Override
	public Type<DeleteContactHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(DeleteContactHandler handler) {
		handler.onDeleteContact(this);
	}
}

package com.aplicant.test.client.event.card.save;

import com.google.gwt.event.shared.GwtEvent;

public class SaveContactEvent extends GwtEvent<SaveContactHandler> {
	public static Type<SaveContactHandler> TYPE = new Type<SaveContactHandler>();

	@Override
	public Type<SaveContactHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(SaveContactHandler handler) {
		handler.onSaveContact(this);
	}
}

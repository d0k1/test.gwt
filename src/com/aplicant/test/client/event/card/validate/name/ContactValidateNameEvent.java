package com.aplicant.test.client.event.card.validate.name;

import com.google.gwt.event.shared.GwtEvent;

public class ContactValidateNameEvent extends GwtEvent<ContactValidateNameHandler> {
	public static Type<ContactValidateNameHandler> TYPE = new Type<ContactValidateNameHandler>();

	@Override
	public Type<ContactValidateNameHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(ContactValidateNameHandler handler) {
		handler.onContactValidateName(this);
	}
}
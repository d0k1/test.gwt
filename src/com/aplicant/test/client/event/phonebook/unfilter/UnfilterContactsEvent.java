package com.aplicant.test.client.event.phonebook.unfilter;

import com.google.gwt.event.shared.GwtEvent;

public class UnfilterContactsEvent extends GwtEvent<UnfilterContactsHandler> {
	public static Type<UnfilterContactsHandler> TYPE = new Type<UnfilterContactsHandler>();

	@Override
	public Type<UnfilterContactsHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(UnfilterContactsHandler handler) {
		handler.onUnfilterContacts(this);
	}
}

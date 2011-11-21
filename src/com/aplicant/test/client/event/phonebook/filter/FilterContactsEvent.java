package com.aplicant.test.client.event.phonebook.filter;

import com.google.gwt.event.shared.GwtEvent;

public class FilterContactsEvent extends GwtEvent<FilterContactsHandler> {
	public static Type<FilterContactsHandler> TYPE = new Type<FilterContactsHandler>();

	@Override
	public Type<FilterContactsHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(FilterContactsHandler handler) {
		handler.onFilterContacts(this);
	}
}

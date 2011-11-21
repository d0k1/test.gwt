package com.aplicant.test.client.event.card.discard;

import com.google.gwt.event.shared.GwtEvent;

public class DiscardContactEvent extends GwtEvent<DiscardContactHandler> {
	public static Type<DiscardContactHandler> TYPE = new Type<DiscardContactHandler>();

	@Override
	public Type<DiscardContactHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(DiscardContactHandler handler) {
		handler.onDiscardContact(this);
	}
}

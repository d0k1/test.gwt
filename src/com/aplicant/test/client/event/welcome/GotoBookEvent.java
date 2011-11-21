package com.aplicant.test.client.event.welcome;

import com.google.gwt.event.shared.GwtEvent;

public class GotoBookEvent extends GwtEvent<GotoBookHandler> {
	public static Type<GotoBookHandler> TYPE = new Type<GotoBookHandler>();

	@Override
	public Type<GotoBookHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(GotoBookHandler handler) {
		handler.onGotoBook(this);
	}
}

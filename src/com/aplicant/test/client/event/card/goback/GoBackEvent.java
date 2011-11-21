package com.aplicant.test.client.event.card.goback;

import com.google.gwt.event.shared.GwtEvent;

public class GoBackEvent extends GwtEvent<GoBackHandler> {
	public static Type<GoBackHandler> TYPE = new Type<GoBackHandler>();

	@Override
	public Type<GoBackHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(GoBackHandler handler) {
		handler.onGoBack(this);
	}
}

package com.aplicant.test.client.event.card.delete;

import com.google.gwt.event.shared.EventHandler;

public interface DeleteContactHandler extends EventHandler {
	void onDeleteContact(DeleteContactEvent event);
}
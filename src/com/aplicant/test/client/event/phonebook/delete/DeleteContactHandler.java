package com.aplicant.test.client.event.phonebook.delete;

import com.aplicant.test.client.event.phonebook.create.CreateContactEvent;
import com.google.gwt.event.shared.EventHandler;

public interface DeleteContactHandler extends EventHandler {
	void onDeleteContact(DeleteContactEvent event);

}

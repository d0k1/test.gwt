package com.aplicant.test.client.factory;

import com.aplicant.test.client.view.phonebook.PhonebookView;
import com.aplicant.test.client.view.welcome.WelcomeView;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

public interface ClientFactory {

	EventBus getEventBus();

	PlaceController getPlaceController();

	WelcomeView getWelcomeView();
	
	PhonebookView getPhonebookView();
}

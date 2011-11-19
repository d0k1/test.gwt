package com.aplicant.test.client.factory;

import com.aplicant.test.client.view.phonebook.PhonebookView;
import com.aplicant.test.client.view.phonebook.PhonebookViewImpl;
import com.aplicant.test.client.view.welcome.WelcomeView;
import com.aplicant.test.client.view.welcome.WelcomeViewImpl;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

public class ClientFactoryImpl implements ClientFactory {

	private final WelcomeView welcomeView = new WelcomeViewImpl();
	private final PhonebookView phonebookView = new PhonebookViewImpl();
	
	private final EventBus eventBus = new SimpleEventBus();
    private final PlaceController placeController = new PlaceController(eventBus);
    
    @Override
	public EventBus getEventBus() {		
		return eventBus;
	}

	@Override
	public PlaceController getPlaceController() {		
		return placeController;
	}

	@Override
	public WelcomeView getWelcomeView() {
		return welcomeView;
	}

	@Override
	public PhonebookView getPhonebookView() {
		return phonebookView;
	}

	
}

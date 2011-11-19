package com.aplicant.test.client.activity;

import com.aplicant.test.client.activity.phonebook.PhonebookActivity;
import com.aplicant.test.client.activity.welcome.WelcomeActivity;
import com.aplicant.test.client.factory.ClientFactory;
import com.aplicant.test.client.place.phonebook.PhonebookPlace;
import com.aplicant.test.client.place.welcome.WelcomePlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class ApplicationActivityMapper implements ActivityMapper {
	private ClientFactory clientFactory;

    public ApplicationActivityMapper(ClientFactory clientFactory) {
        super();
        this.clientFactory = clientFactory;
    }

    @Override
    public Activity getActivity(Place place) {
        if (place instanceof WelcomePlace)
            return new WelcomeActivity((WelcomePlace) place, clientFactory);
        else if (place instanceof PhonebookPlace)
        	return new PhonebookActivity((PhonebookPlace) place, clientFactory);
        return null;
    }
}

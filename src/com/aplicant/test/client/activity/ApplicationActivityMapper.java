package com.aplicant.test.client.activity;

import com.aplicant.test.client.activity.create.CreateActivity;
import com.aplicant.test.client.activity.details.DetailsActivity;
import com.aplicant.test.client.activity.phonebook.PhonebookActivity;
import com.aplicant.test.client.activity.welcome.WelcomeActivity;
import com.aplicant.test.client.factory.ClientFactory;
import com.aplicant.test.client.place.create.Create;
import com.aplicant.test.client.place.details.Details;
import com.aplicant.test.client.place.phonebook.Phonebook;
import com.aplicant.test.client.place.welcome.Welcome;
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
        if (place instanceof Welcome)
            return new WelcomeActivity((Welcome) place, clientFactory);
        else if (place instanceof Phonebook)
        	return new PhonebookActivity((Phonebook) place, clientFactory);
        else if (place instanceof Create)
        	return new CreateActivity(clientFactory);
        else if (place instanceof Details)
        	return new DetailsActivity((Details) place, clientFactory);
        return null;
    }
}

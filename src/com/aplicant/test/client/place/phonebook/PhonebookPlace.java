package com.aplicant.test.client.place.phonebook;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class PhonebookPlace extends Place {
	
	public static class Tokenizer implements PlaceTokenizer<PhonebookPlace> {
        @Override
        public String getToken(PhonebookPlace place) {
            return "";
        }

        @Override
        public PhonebookPlace getPlace(String token) {
            return new PhonebookPlace();
        }
    }
}

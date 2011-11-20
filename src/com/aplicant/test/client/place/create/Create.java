package com.aplicant.test.client.place.create;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class Create extends Place {

	public Create() {
		super();
	}

	public static class Tokenizer implements PlaceTokenizer<Create> {
        @Override
        public String getToken(Create place) {
            return "";
        }

        @Override
        public Create getPlace(String token) {
            return new Create();
        }
    }
}

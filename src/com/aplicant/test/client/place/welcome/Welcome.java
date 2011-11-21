package com.aplicant.test.client.place.welcome;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class Welcome extends Place {
	
	public Welcome() {
    }

    public static class Tokenizer implements PlaceTokenizer<Welcome> {
        @Override
        public String getToken(Welcome place) {
            return "";
        }

        @Override
        public Welcome getPlace(String token) {
            return new Welcome();
        }
    }
}

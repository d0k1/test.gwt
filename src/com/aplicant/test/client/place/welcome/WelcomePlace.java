package com.aplicant.test.client.place.welcome;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class WelcomePlace extends Place {
	private String greetingsMessage = "Greetings";
	
	public WelcomePlace(String token) {
        this.greetingsMessage = token;
    }

    public String getGreetingsMessage() {
        return greetingsMessage;
    }

    public static class Tokenizer implements PlaceTokenizer<WelcomePlace> {
        @Override
        public String getToken(WelcomePlace place) {
            return place.getGreetingsMessage();
        }

        @Override
        public WelcomePlace getPlace(String token) {
            return new WelcomePlace(token);
        }
    }
}

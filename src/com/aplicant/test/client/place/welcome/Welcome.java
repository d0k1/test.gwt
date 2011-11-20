package com.aplicant.test.client.place.welcome;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class Welcome extends Place {
	private String greetingsMessage = "Greetings";
	
	public Welcome(String token) {
        this.greetingsMessage = token;
    }

    public String getGreetingsMessage() {
        return greetingsMessage;
    }

    public static class Tokenizer implements PlaceTokenizer<Welcome> {
        @Override
        public String getToken(Welcome place) {
            return place.getGreetingsMessage();
        }

        @Override
        public Welcome getPlace(String token) {
            return new Welcome(token);
        }
    }
}

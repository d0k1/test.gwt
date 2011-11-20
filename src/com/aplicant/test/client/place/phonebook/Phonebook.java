package com.aplicant.test.client.place.phonebook;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class Phonebook extends Place {
	private String filter = "";
	
	public Phonebook(String filter){
		this.filter = filter;
	}
	
	public String getFilter(){
		return filter;
	}
	
	public static class Tokenizer implements PlaceTokenizer<Phonebook> {
        @Override
        public String getToken(Phonebook place) {
            return place.getFilter();
        }

        @Override
        public Phonebook getPlace(String token) {
            return new Phonebook(token);
        }
    }
}

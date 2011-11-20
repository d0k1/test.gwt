package com.aplicant.test.client.place.details;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class Details extends Place {

	private String contactId = "";
	
	public void setContactId(String id){
		this.contactId = id;
	}
	
	public String getContactId(){
		return contactId;
	}
	
	public Details(String contactId) {
		super();
		this.contactId = contactId;
	}

	public static class Tokenizer implements PlaceTokenizer<Details> {
        @Override
        public String getToken(Details place) {
            return place.getContactId();
        }

        @Override
        public Details getPlace(String token) {
            return new Details(token);
        }
    }

}

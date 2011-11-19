package com.aplicant.test.client.place.card;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class CardPlace extends Place {

	private String contactId = "";
	
	public void setContactId(String id){
		this.contactId = id;
	}
	
	public String getContactId(){
		return contactId;
	}
	
	public CardPlace(String contactId) {
		super();
		this.contactId = contactId;
	}

	public static class Tokenizer implements PlaceTokenizer<CardPlace> {
        @Override
        public String getToken(CardPlace place) {
            return place.getContactId();
        }

        @Override
        public CardPlace getPlace(String token) {
            return new CardPlace(token);
        }
    }

}

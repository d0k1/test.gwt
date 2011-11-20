package com.aplicant.test.client.place.card;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class Card extends Place {

	private String contactId = "";
	
	public void setContactId(String id){
		this.contactId = id;
	}
	
	public String getContactId(){
		return contactId;
	}
	
	public Card(String contactId) {
		super();
		this.contactId = contactId;
	}

	public static class Tokenizer implements PlaceTokenizer<Card> {
        @Override
        public String getToken(Card place) {
            return place.getContactId();
        }

        @Override
        public Card getPlace(String token) {
            return new Card(token);
        }
    }

}

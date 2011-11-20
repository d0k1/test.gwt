package com.aplicant.test.client.place;

import com.aplicant.test.client.place.card.Card;
import com.aplicant.test.client.place.phonebook.Phonebook;
import com.aplicant.test.client.place.welcome.Welcome;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({Welcome.Tokenizer.class, Phonebook.Tokenizer.class, Card.Tokenizer.class})
public interface ApplicationHistoryMapper extends PlaceHistoryMapper {

}

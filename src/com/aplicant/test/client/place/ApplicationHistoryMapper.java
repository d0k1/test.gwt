package com.aplicant.test.client.place;

import com.aplicant.test.client.place.card.CardPlace;
import com.aplicant.test.client.place.welcome.WelcomePlace;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({WelcomePlace.Tokenizer.class, CardPlace.Tokenizer.class})
public interface ApplicationHistoryMapper extends PlaceHistoryMapper {

}

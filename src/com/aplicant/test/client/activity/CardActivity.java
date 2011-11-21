package com.aplicant.test.client.activity;

import net.customware.gwt.dispatch.client.DispatchAsync;

import com.aplicant.test.client.factory.ClientFactory;
import com.aplicant.test.client.place.phonebook.Phonebook;
import com.aplicant.test.client.presenter.card.CardPresenter;
import com.aplicant.test.shared.NameFieldVerifier;
import com.aplicant.test.shared.PhoneFieldVerifier;
import com.google.gwt.activity.shared.AbstractActivity;

public abstract class CardActivity extends AbstractActivity implements CardPresenter {
	private ClientFactory clientFactory;
	private DispatchAsync dispatch;

	protected final ClientFactory getClientFactory(){
		return clientFactory;
	}
	
	protected final void setClientFactory(ClientFactory clientFactory){
		this.clientFactory = clientFactory;
		this.dispatch = clientFactory.getDispatch();
	}
	
	protected final DispatchAsync getDispatch(){
		return dispatch;
	}

	@Override
	public final void discard() {
		goBack();
	}

	@Override
	public final void goBack() {
		clientFactory.getPlaceController().goTo(new Phonebook(""));
	}

	@Override
	public final boolean validateName(String value) {
		return NameFieldVerifier.isValidName(value);
	}

	@Override
	public final boolean validatePhone(String value) {
		return PhoneFieldVerifier.isValidPhone(value);
	}

}

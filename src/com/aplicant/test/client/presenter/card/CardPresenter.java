package com.aplicant.test.client.presenter.card;

public interface CardPresenter {
	void save();
	void discard();
	void delete();
	void goBack();
	
	boolean validateName(String value);
	boolean validatePhone(String value);
}

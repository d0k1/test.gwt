package com.aplicant.test.client.activity.details;

import net.customware.gwt.dispatch.client.DispatchAsync;

import com.aplicant.test.client.factory.ClientFactory;
import com.aplicant.test.client.place.phonebook.Phonebook;
import com.aplicant.test.client.presenter.details.DetailsPresenter;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class DetailsActivity extends AbstractActivity implements DetailsPresenter {
	private ClientFactory clientFactory;
	private Phonebook place;
	private DispatchAsync dispatch;
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateContact(String id, String name, String phone) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void gotoPhonebook() {
		// TODO Auto-generated method stub
		
	}

}

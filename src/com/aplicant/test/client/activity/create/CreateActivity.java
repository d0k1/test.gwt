package com.aplicant.test.client.activity.create;

import net.customware.gwt.dispatch.client.DispatchAsync;

import com.aplicant.test.client.factory.ClientFactory;
import com.aplicant.test.client.place.phonebook.Phonebook;
import com.aplicant.test.client.presenter.create.CreatePresenter;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class CreateActivity extends AbstractActivity implements CreatePresenter {
	private ClientFactory clientFactory;
	private Phonebook place;
	private DispatchAsync dispatch;
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void createContact(String name, String phone) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void gotoPhonebook() {
		// TODO Auto-generated method stub
		
	}

}

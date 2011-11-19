package com.aplicant.test.client.activity.phonebook;

import com.aplicant.test.client.factory.ClientFactory;
import com.aplicant.test.client.place.phonebook.PhonebookPlace;
import com.aplicant.test.client.presenter.phonebook.PhonebookPresenter;
import com.aplicant.test.client.view.phonebook.PhonebookView;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class PhonebookActivity extends AbstractActivity implements PhonebookPresenter {
	private ClientFactory clientFactory;
	private PhonebookPlace place;
	
	public PhonebookActivity(PhonebookPlace place, ClientFactory factory){
		this.clientFactory = factory;
		this.place = place;
	}	
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		PhonebookView view = clientFactory.getPhonebookView();
		view.setPresenter(this);
		panel.setWidget(view.asWidget());
	}

	
}

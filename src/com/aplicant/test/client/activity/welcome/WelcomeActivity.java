package com.aplicant.test.client.activity.welcome;

import com.aplicant.test.client.factory.ClientFactory;
import com.aplicant.test.client.place.phonebook.PhonebookPlace;
import com.aplicant.test.client.place.welcome.WelcomePlace;
import com.aplicant.test.client.presenter.welcome.WelcomePresenter;
import com.aplicant.test.client.view.welcome.WelcomeView;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class WelcomeActivity extends AbstractActivity implements WelcomePresenter {
	
	private ClientFactory clientFactory;
	private WelcomePlace place;
	
	public WelcomeActivity(WelcomePlace place, ClientFactory factory){
		this.clientFactory = factory;
		this.place = place;
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		WelcomeView view = clientFactory.getWelcomeView();
		view.setWelcomeMessage(place.getGreetingsMessage());
		view.setPresenter(this);
		panel.setWidget(view.asWidget());
	}

	@Override
	public void gotoPhonebook() {
		clientFactory.getPlaceController().goTo(new PhonebookPlace());		
	}

}

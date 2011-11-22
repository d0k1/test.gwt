package com.aplicant.test.client.activity.welcome;

import com.aplicant.test.client.activity.CommonActivity;
import com.aplicant.test.client.event.welcome.GotoBookEvent;
import com.aplicant.test.client.event.welcome.GotoBookHandler;
import com.aplicant.test.client.factory.ClientFactory;
import com.aplicant.test.client.place.phonebook.Phonebook;
import com.aplicant.test.client.view.welcome.WelcomeView;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class WelcomeActivity extends CommonActivity {
	
	private ClientFactory clientFactory;
	public WelcomeActivity(ClientFactory factory){
		this.clientFactory = factory;
		
		bindEvents();
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		WelcomeView view = clientFactory.getWelcomeView();
		view.setEventBus(clientFactory.getEventBus());
		panel.setWidget(view.asWidget());
	}

	private void gotoPhonebook() {
		clientFactory.getPlaceController().goTo(new Phonebook(""));		
	}

	@Override
	protected void bindEvents() {
		storeEventHandler(clientFactory.getEventBus().addHandler(GotoBookEvent.TYPE, new GotoBookHandler() {
			
			@Override
			public void onGotoBook(GotoBookEvent event) {
				gotoPhonebook();
			}
		}));
	}
}

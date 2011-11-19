package com.aplicant.test.client;

import com.aplicant.test.client.activity.ApplicationActivityMapper;
import com.aplicant.test.client.factory.ClientFactory;
import com.aplicant.test.client.place.ApplicationHistoryMapper;
import com.aplicant.test.client.place.welcome.WelcomePlace;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.web.bindery.event.shared.EventBus;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class NAT implements EntryPoint {
	private SimplePanel appWidget = new SimplePanel();
	private WelcomePlace defaultPlace = new WelcomePlace("Greetings");
	
	public void onModuleLoad() {
        ClientFactory clientFactory = GWT.create(ClientFactory.class);
        EventBus eventBus = clientFactory.getEventBus();
        PlaceController placeController = clientFactory.getPlaceController();
		
        // Start ActivityManager for the main widget with our ActivityMapper
        ActivityMapper activityMapper = new ApplicationActivityMapper(clientFactory);
        ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
        activityManager.setDisplay(appWidget);
        
        // Start PlaceHistoryHandler with our PlaceHistoryMapper
        ApplicationHistoryMapper historyMapper= GWT.create(ApplicationHistoryMapper.class);
        PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
        historyHandler.register(placeController, eventBus, defaultPlace);

        RootPanel.get().add(appWidget);
        // Goes to the place represented on URL else default place
        historyHandler.handleCurrentHistory();       
	}
}

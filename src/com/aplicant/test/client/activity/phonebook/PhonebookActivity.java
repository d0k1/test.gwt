package com.aplicant.test.client.activity.phonebook;

import net.customware.gwt.dispatch.client.DispatchAsync;

import com.aplicant.test.client.factory.ClientFactory;
import com.aplicant.test.client.place.phonebook.Phonebook;
import com.aplicant.test.client.presenter.phonebook.PhonebookPresenter;
import com.aplicant.test.client.view.phonebook.PhonebookView;
import com.aplicant.test.shared.action.get.GetContactsAction;
import com.aplicant.test.shared.action.get.GetContactsResult;
import com.aplicant.test.shared.model.Contact;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.ListBox;

public class PhonebookActivity extends AbstractActivity implements PhonebookPresenter {
	private ClientFactory clientFactory;
	private Phonebook place;
	private DispatchAsync dispatch;
	
	public PhonebookActivity(Phonebook place, ClientFactory factory){
		this.clientFactory = factory;
		this.place = place;
		this.dispatch = clientFactory.getDispatch();
	}	
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		final PhonebookView view = clientFactory.getPhonebookView();
		view.setPresenter(this);
		panel.setWidget(view.asWidget());
		
		dispatch.execute(new GetContactsAction(""), new AsyncCallback<GetContactsResult>() {

            public void onFailure(Throwable caught) {
            	Window.alert("Error getting contacts");
            }

            public void onSuccess(GetContactsResult result) {
            	ListBox b = view.getContactListBox();
            	b.clear();
            	
            	for (Contact item : result.getContacts()) {
                	b.addItem(item.name);
				}
            }
        });
	}

	
}

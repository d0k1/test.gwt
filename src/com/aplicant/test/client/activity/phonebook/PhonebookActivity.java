package com.aplicant.test.client.activity.phonebook;

import java.util.ArrayList;

import net.customware.gwt.dispatch.client.DispatchAsync;

import com.aplicant.test.client.factory.ClientFactory;
import com.aplicant.test.client.place.details.Details;
import com.aplicant.test.client.place.phonebook.Phonebook;
import com.aplicant.test.client.place.welcome.Welcome;
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
	private ArrayList<Contact> currentContacts = new ArrayList<Contact>();
	
	public PhonebookActivity(Phonebook place, ClientFactory factory){
		this.clientFactory = factory;
		this.place = place;
		this.dispatch = clientFactory.getDispatch();
	}	
	
	@Override
	public void start(final AcceptsOneWidget panel, EventBus eventBus) {
		final Object presenter = this;
		dispatch.execute(new GetContactsAction(""), new AsyncCallback<GetContactsResult>() {

            public void onFailure(Throwable caught) {
            	Window.alert("Ошибка при получении списка контактов");
            	clientFactory.getPlaceController().goTo(new Welcome());
            }

            public void onSuccess(GetContactsResult result) {
        		final PhonebookView view = clientFactory.getPhonebookView();
        		view.setPresenter(presenter);
        		panel.setWidget(view.asWidget());
        		
            	ListBox b = view.getContactListBox();
            	b.clear();
            	currentContacts.addAll(result.getContacts());
            	
            	for (Contact item : currentContacts) {
                	b.addItem(item.name);
				}
            }
        });
	}

	@Override
	public void createContact() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateContact(int index) {
		if(index>=0 && index<currentContacts.size()){
			clientFactory.getPlaceController().goTo(new Details(currentContacts.get(index).id));
		}
	}

	@Override
	public void deleteContact(int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void filterContacts(int index) {
		// TODO Auto-generated method stub
		
	}
	
}

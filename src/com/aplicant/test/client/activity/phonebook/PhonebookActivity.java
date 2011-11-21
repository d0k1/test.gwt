package com.aplicant.test.client.activity.phonebook;

import java.util.ArrayList;

import net.customware.gwt.dispatch.client.DispatchAsync;

import com.aplicant.test.client.factory.ClientFactory;
import com.aplicant.test.client.place.create.Create;
import com.aplicant.test.client.place.details.Details;
import com.aplicant.test.client.place.phonebook.Phonebook;
import com.aplicant.test.client.place.welcome.Welcome;
import com.aplicant.test.client.presenter.phonebook.PhonebookPresenter;
import com.aplicant.test.client.view.phonebook.PhonebookView;
import com.aplicant.test.shared.action.delete.DeleteContactAction;
import com.aplicant.test.shared.action.delete.DeleteContactResult;
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
	private final PhonebookView view;
	
	public PhonebookActivity(Phonebook place, ClientFactory factory){
		this.clientFactory = factory;
		this.place = place;
		this.dispatch = clientFactory.getDispatch();
		view = clientFactory.getPhonebookView();
	}
	
	@Override
	public void start(final AcceptsOneWidget panel, EventBus eventBus) {
		final Object presenter = this;
		dispatch.execute(new GetContactsAction(place.getFilter()), new AsyncCallback<GetContactsResult>() {

            public void onFailure(Throwable caught) {
            	Window.alert("Ошибка при получении списка контактов");
            	clientFactory.getPlaceController().goTo(new Welcome());
            }

            public void onSuccess(GetContactsResult result) {        		
        		view.setPresenter(presenter);
        		panel.setWidget(view.asWidget());
        		
        		if(place.getFilter().length()>0)
        			view.setFilterState(true);
        		else
        			view.setFilterState(false);
        		
        		view.getFilterInput().setText(place.getFilter());
        		
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
		clientFactory.getPlaceController().goTo(new Create());
	}

	@Override
	public void updateContact(int index) {
		if(index>=0 && index<currentContacts.size()){
			clientFactory.getPlaceController().goTo(new Details(currentContacts.get(index).id));
		}
	}

	@Override
	public void deleteContact(int index) {
		dispatch.execute(new DeleteContactAction(currentContacts.get(index).id), new AsyncCallback<DeleteContactResult>() {

            public void onFailure(Throwable caught) {
            	Window.alert("Ошибка при получении списка контактов");
            }

            public void onSuccess(DeleteContactResult result) {
            	if(place.getFilter().length()>0){
            		filterContacts(place.getFilter());
            	} else {
            		unfilterContacts();
            	}
            }
        });
	}

	@Override
	public void filterContacts(String name) {
		clientFactory.getPlaceController().goTo(new Phonebook(name));
	}

	@Override
	public void unfilterContacts() {
		clientFactory.getPlaceController().goTo(new Phonebook(""));
	}
	
}

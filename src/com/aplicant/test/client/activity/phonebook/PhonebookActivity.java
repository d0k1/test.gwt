package com.aplicant.test.client.activity.phonebook;

import net.customware.gwt.dispatch.client.DispatchAsync;

import com.aplicant.test.client.activity.CommonActivity;
import com.aplicant.test.client.event.phonebook.create.CreateContactEvent;
import com.aplicant.test.client.event.phonebook.delete.DeleteContactEvent;
import com.aplicant.test.client.event.phonebook.delete.DeleteContactHandler;
import com.aplicant.test.client.event.phonebook.filter.FilterContactsEvent;
import com.aplicant.test.client.event.phonebook.filter.FilterContactsHandler;
import com.aplicant.test.client.event.phonebook.unfilter.UnfilterContactsEvent;
import com.aplicant.test.client.event.phonebook.unfilter.UnfilterContactsHandler;
import com.aplicant.test.client.event.phonebook.update.UpdateContactEvent;
import com.aplicant.test.client.event.phonebook.update.UpdateContactHandler;
import com.aplicant.test.client.factory.ClientFactory;
import com.aplicant.test.client.place.create.Create;
import com.aplicant.test.client.place.details.Details;
import com.aplicant.test.client.place.phonebook.Phonebook;
import com.aplicant.test.client.place.welcome.Welcome;
import com.aplicant.test.client.view.phonebook.PhonebookView;
import com.aplicant.test.shared.action.delete.DeleteContactAction;
import com.aplicant.test.shared.action.delete.DeleteContactResult;
import com.aplicant.test.shared.action.get.GetContactsAction;
import com.aplicant.test.shared.action.get.GetContactsResult;
import com.aplicant.test.shared.model.Contact;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class PhonebookActivity extends CommonActivity {
	private ClientFactory clientFactory;
	private Phonebook place;
	private DispatchAsync dispatch;
	private final PhonebookView view;
	
	public PhonebookActivity(Phonebook place, ClientFactory factory){
		this.clientFactory = factory;
		this.place = place;
		this.dispatch = clientFactory.getDispatch();
		view = clientFactory.getPhonebookView();
		view.setEventBus(clientFactory.getEventBus());
		
		bindEvents();
	}
	
	@Override
	public void start(final AcceptsOneWidget panel, EventBus eventBus) {
		dispatch.execute(new GetContactsAction(place.getFilter()), new AsyncCallback<GetContactsResult>() {

            public void onFailure(Throwable caught) {
            	Window.alert("Ошибка при получении списка контактов");
            	clientFactory.getPlaceController().goTo(new Welcome());
            }

            public void onSuccess(GetContactsResult result) {
            	
        		//view.setPresenter(presenter);
        		panel.setWidget(view.asWidget());
        		view.setData(result.getContacts());
        		String f = place.getFilter();
        		
        		view.getFilterInput().setText(f);
            }
        });
	}

	private void createContact() {
		clientFactory.getPlaceController().goTo(new Create());
	}

	private void updateContact(Contact contact) {
		clientFactory.getPlaceController().goTo(new Details(contact.id));
	}

	private void deleteContact(Contact contact) {
		dispatch.execute(new DeleteContactAction(contact.id), new AsyncCallback<DeleteContactResult>() {

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

	private void filterContacts(String name) {
		clientFactory.getPlaceController().goTo(new Phonebook(name));
	}

	private void unfilterContacts() {
		clientFactory.getPlaceController().goTo(new Phonebook(""));
	}

	@Override
	public void bindEvents() {
		storeEventHandler(clientFactory.getEventBus().addHandler(CreateContactEvent.TYPE, new com.aplicant.test.client.event.phonebook.create.CreateContactHandler() {
			
			@Override
			public void onCreateContact(CreateContactEvent event) {
				createContact();
			}
		}));
		
		storeEventHandler(clientFactory.getEventBus().addHandler(DeleteContactEvent.TYPE, new DeleteContactHandler() {
			
			@Override
			public void onDeleteContact(DeleteContactEvent event) {
				deleteContact(event.getContact());
			}
		}));
		
		storeEventHandler(clientFactory.getEventBus().addHandler(UpdateContactEvent.TYPE, new UpdateContactHandler() {
			
			@Override
			public void onUpdateContact(UpdateContactEvent event) {
				updateContact(event.getContact());
			}
		}));
		
		storeEventHandler(clientFactory.getEventBus().addHandler(FilterContactsEvent.TYPE, new FilterContactsHandler() {
			
			@Override
			public void onFilterContacts(FilterContactsEvent event) {
				filterContacts(event.getFilter());
			}
		}));
		
		storeEventHandler(clientFactory.getEventBus().addHandler(UnfilterContactsEvent.TYPE, new UnfilterContactsHandler() {
			
			@Override
			public void onUnfilterContacts(UnfilterContactsEvent event) {
				unfilterContacts();
			}
		}));
	}
}

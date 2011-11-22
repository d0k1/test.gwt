package com.aplicant.test.client.activity.card;

import net.customware.gwt.dispatch.client.DispatchAsync;

import com.aplicant.test.client.activity.CommonActivity;
import com.aplicant.test.client.event.card.delete.DeleteContactEvent;
import com.aplicant.test.client.event.card.delete.DeleteContactHandler;
import com.aplicant.test.client.event.card.discard.DiscardContactEvent;
import com.aplicant.test.client.event.card.discard.DiscardContactHandler;
import com.aplicant.test.client.event.card.goback.GoBackEvent;
import com.aplicant.test.client.event.card.goback.GoBackHandler;
import com.aplicant.test.client.event.card.save.SaveContactEvent;
import com.aplicant.test.client.event.card.save.SaveContactHandler;
import com.aplicant.test.client.event.card.validate.name.ContactValidateNameEvent;
import com.aplicant.test.client.event.card.validate.name.ContactValidateNameHandler;
import com.aplicant.test.client.event.card.validate.phone.ContactValidatePhoneEvent;
import com.aplicant.test.client.event.card.validate.phone.ContactValidatePhoneHandler;
import com.aplicant.test.client.factory.ClientFactory;
import com.aplicant.test.client.place.phonebook.Phonebook;
import com.aplicant.test.client.view.card.CardView;
import com.aplicant.test.shared.model.Contact;
import com.aplicant.test.shared.validate.NameFieldVerifier;
import com.aplicant.test.shared.validate.PhoneFieldVerifier;

public abstract class CommonCardActivity extends CommonActivity {
	private ClientFactory clientFactory;
	private DispatchAsync dispatch;
	private CardView view;

	protected final CardView getView(){
		return view;
	}
	
	protected final ClientFactory getClientFactory(){
		return clientFactory;
	}
	
	protected final void setClientFactory(ClientFactory clientFactory){
		this.clientFactory = clientFactory;
		this.dispatch = clientFactory.getDispatch();
		view = clientFactory.getCardView();
		view.setEventBus(clientFactory.getEventBus());
	}
	
	protected final DispatchAsync getDispatch(){
		return dispatch;
	}

	public final void discard() {
		goBack();
	}

	public final void goBack() {
		clientFactory.getPlaceController().goTo(new Phonebook(""));
	}

	protected abstract void save(Contact c);
	protected abstract void delete(Contact c);
	
	protected final boolean validateName(String value) {
		return NameFieldVerifier.isValidName(value);
	}

	protected final boolean validatePhone(String value) {
		return PhoneFieldVerifier.isValidPhone(value);
	}

	public final void bindEvents(){
		storeEventHandler(clientFactory.getEventBus().addHandler(DeleteContactEvent.TYPE, new DeleteContactHandler() {
			
			@Override
			public void onDeleteContact(DeleteContactEvent event) {
				delete(event.getContact());
			}
		}));
		
		storeEventHandler(clientFactory.getEventBus().addHandler(DiscardContactEvent.TYPE, new DiscardContactHandler() {
			
			@Override
			public void onDiscardContact(DiscardContactEvent event) {
				discard();
			}
		}));
		
		storeEventHandler(clientFactory.getEventBus().addHandler(GoBackEvent.TYPE, new GoBackHandler() {
			
			@Override
			public void onGoBack(GoBackEvent event) {
				goBack();
			}
		}));
		
		storeEventHandler(clientFactory.getEventBus().addHandler(SaveContactEvent.TYPE, new SaveContactHandler() {
			
			@Override
			public void onSaveContact(SaveContactEvent event) {
				save(event.getContact());
			}
		}));
		
		storeEventHandler(clientFactory.getEventBus().addHandler(ContactValidateNameEvent.TYPE, new ContactValidateNameHandler() {
			
			@Override
			public void onContactValidateName(ContactValidateNameEvent event) {
				if(validateName(event.getName())){
					getView().nameValidationOk();
				} else {
					getView().nameValidationError();
				}
			}
		}));
		
		storeEventHandler(clientFactory.getEventBus().addHandler(ContactValidatePhoneEvent.TYPE, new ContactValidatePhoneHandler() {
			
			@Override
			public void onContactValidatePhone(ContactValidatePhoneEvent event) {
				if(validatePhone(event.getPhone())){
					getView().phoneValidationOk();
				} else {
					getView().phoneValidationError();
				}
			}
		}));
		
	}
	
}

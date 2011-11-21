package com.aplicant.test.client.activity.card.details;

import com.aplicant.test.client.activity.card.CommonCardActivity;
import com.aplicant.test.client.factory.ClientFactory;
import com.aplicant.test.client.place.details.Details;
import com.aplicant.test.shared.action.delete.DeleteContactAction;
import com.aplicant.test.shared.action.delete.DeleteContactResult;
import com.aplicant.test.shared.action.get.GetContactByIdAction;
import com.aplicant.test.shared.action.get.GetContactByIdResult;
import com.aplicant.test.shared.action.update.UpdateContactAction;
import com.aplicant.test.shared.action.update.UpdateContactResult;
import com.aplicant.test.shared.model.Contact;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class DetailsActivity extends CommonCardActivity {
	private Details place;
	//private Contact currentContact = null;
	
	public DetailsActivity(Details place, ClientFactory clientFactory) {
		super();
		super.setClientFactory(clientFactory);
		this.place = place;
		
		bindEvents();
	}
	
	@Override
	public void start(final AcceptsOneWidget panel, EventBus eventBus) {
		getDispatch().execute(new GetContactByIdAction(place.getContactId()), new AsyncCallback<GetContactByIdResult>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Ошибка получени контакта: "+caught.getMessage());
				goBack();
			}

			@Override
			public void onSuccess(GetContactByIdResult result) {		
				getView().setDeletable(true);
				 
				getView().setContact(result.getContact());
				panel.setWidget(getView().asWidget());
			}
		});
	}
	
	@Override
	public void save(Contact contact) {
		getDispatch().execute(new UpdateContactAction(contact), new AsyncCallback<UpdateContactResult>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Ошибка сохранения данных");				
			}

			@Override
			public void onSuccess(UpdateContactResult result) {
				goBack();
			}
		});
	}
	
	@Override
	public void delete(Contact contact) {
		getDispatch().execute(new DeleteContactAction(contact.id), new AsyncCallback<DeleteContactResult>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Ошибка удаления контакта");
			}

			@Override
			public void onSuccess(DeleteContactResult result) {
				goBack();
			}
			
		});
	}

}

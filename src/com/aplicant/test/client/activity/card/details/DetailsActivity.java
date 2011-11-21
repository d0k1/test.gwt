package com.aplicant.test.client.activity.card.details;

import com.aplicant.test.client.activity.card.CommonCardActivity;
import com.aplicant.test.client.factory.ClientFactory;
import com.aplicant.test.client.place.details.Details;
import com.aplicant.test.client.presenter.card.CardPresenter;
import com.aplicant.test.client.view.card.CardView;
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

public class DetailsActivity extends CommonCardActivity implements CardPresenter {
	private Details place;
	private Contact currentContact = null;
	private final CardView view;
	
	public DetailsActivity(Details place, ClientFactory clientFactory) {
		super();
		super.setClientFactory(clientFactory);
		this.place = place;
		view = getClientFactory().getCardView();
	}
	
	@Override
	public void start(final AcceptsOneWidget panel, EventBus eventBus) {
		final Object presenter = this;
		getDispatch().execute(new GetContactByIdAction(place.getContactId()), new AsyncCallback<GetContactByIdResult>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Ошибка получени контакта: "+caught.getMessage());
				goBack();
			}

			@Override
			public void onSuccess(GetContactByIdResult result) {		
				view.setDeletable(true);
				view.setPresenter(presenter);
				currentContact = result.getContact();
				view.setContact(currentContact);
				panel.setWidget(view.asWidget());
			}
		});
	}
	
	@Override
	public void save() {
		getDispatch().execute(new UpdateContactAction(view.getContact()), new AsyncCallback<UpdateContactResult>() {

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
	public void delete() {
		getDispatch().execute(new DeleteContactAction(currentContact.id), new AsyncCallback<DeleteContactResult>() {

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

package com.aplicant.test.client.activity.details;

import net.customware.gwt.dispatch.client.DispatchAsync;

import com.aplicant.test.client.factory.ClientFactory;
import com.aplicant.test.client.place.details.Details;
import com.aplicant.test.client.place.phonebook.Phonebook;
import com.aplicant.test.client.presenter.card.CardPresenter;
import com.aplicant.test.client.view.card.CardView;
import com.aplicant.test.shared.NameFieldVerifier;
import com.aplicant.test.shared.PhoneFieldVerifier;
import com.aplicant.test.shared.action.get.GetContactByIdAction;
import com.aplicant.test.shared.action.get.GetContactByIdResult;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class DetailsActivity extends AbstractActivity implements CardPresenter {
	private ClientFactory clientFactory;
	private Details place;
	private DispatchAsync dispatch;
	
	public DetailsActivity(ClientFactory clientFactory, Details place) {
		super();
		this.clientFactory = clientFactory;
		this.place = place;
		this.dispatch = clientFactory.getDispatch();
	}
	
	@Override
	public void start(final AcceptsOneWidget panel, EventBus eventBus) {
		final Object presenter = this;
		dispatch.execute(new GetContactByIdAction(place.getContactId()), new AsyncCallback<GetContactByIdResult>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Ошибка получени контакта");
			}

			@Override
			public void onSuccess(GetContactByIdResult result) {
				CardView view = clientFactory.getCardView();
				view.setDeletable(true);
				view.setPresenter(presenter);
				view.setContact(result.getContact());
				panel.setWidget(view.asWidget());
			}
		});
	}
	
	@Override
	public void save() {
	}
	@Override
	public void discard() {
		goBack();
	}
	
	@Override
	public void goBack() {
	}

	@Override
	public boolean validateName(String value) {
		
		return NameFieldVerifier.isValidName(value);
	}
	
	@Override
	public boolean validatePhone(String value) {

		return PhoneFieldVerifier.isValidPhone(value);
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

}

package com.aplicant.test.client.activity.card.create;

import net.customware.gwt.dispatch.client.DispatchAsync;

import com.aplicant.test.client.activity.card.CommonCardActivity;
import com.aplicant.test.client.factory.ClientFactory;
import com.aplicant.test.client.place.create.Create;
import com.aplicant.test.client.place.phonebook.Phonebook;
import com.aplicant.test.client.presenter.card.CardPresenter;
import com.aplicant.test.client.view.card.CardView;
import com.aplicant.test.shared.action.create.CreateContactAction;
import com.aplicant.test.shared.action.create.CreateContactResult;
import com.aplicant.test.shared.action.get.GetContactByIdAction;
import com.aplicant.test.shared.action.get.GetContactByIdResult;
import com.aplicant.test.shared.action.update.UpdateContactAction;
import com.aplicant.test.shared.action.update.UpdateContactResult;
import com.aplicant.test.shared.model.Contact;
import com.aplicant.test.shared.validate.NameFieldVerifier;
import com.aplicant.test.shared.validate.PhoneFieldVerifier;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class CreateActivity extends CommonCardActivity implements CardPresenter {
	private final CardView view;

	public CreateActivity(ClientFactory clientFactory) {
		super();
		super.setClientFactory(clientFactory);
		view = clientFactory.getCardView();
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		final Object presenter = this;		
		view.setDeletable(false);
		view.setPresenter(presenter);
		
		// Для чистоты можно было бы вызвать удаленный метод для создания контакта, но это в данном случае слишком накладно
		view.setContact(new Contact("Без имени", "Без телефона"));
		panel.setWidget(view.asWidget());
	}
	
	@Override
	public void save() {
		getDispatch().execute(new CreateContactAction(view.getContact()), new AsyncCallback<CreateContactResult>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Ошибка сохранения данных");				
			}

			@Override
			public void onSuccess(CreateContactResult result) {
				goBack();
			}
		});
	}

	@Override
	public void delete() {
		goBack();
	}

}

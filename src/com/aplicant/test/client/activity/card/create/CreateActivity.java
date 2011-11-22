package com.aplicant.test.client.activity.card.create;

import com.aplicant.test.client.activity.card.CommonCardActivity;
import com.aplicant.test.client.factory.ClientFactory;
import com.aplicant.test.shared.action.create.CreateContactAction;
import com.aplicant.test.shared.action.create.CreateContactResult;
import com.aplicant.test.shared.model.Contact;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class CreateActivity extends CommonCardActivity {

	public CreateActivity(ClientFactory clientFactory) {
		super();
		super.setClientFactory(clientFactory);
		
		bindEvents();
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		getView().setDeletable(false);
		
		// Для чистоты можно было бы вызвать удаленный метод для создания контакта, но это в данном случае слишком накладно
		getView().setContact(new Contact("Без имени", "Без телефона"));
		panel.setWidget(getView().asWidget());
	}
	
	@Override
	protected void save(Contact contact) {
		getDispatch().execute(new CreateContactAction(contact), new AsyncCallback<CreateContactResult>() {

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
	protected void delete(Contact contact) {
		goBack();
	}
}

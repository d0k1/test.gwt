package com.aplicant.test.client.view.card;

import com.aplicant.test.client.event.card.delete.DeleteContactEvent;
import com.aplicant.test.client.event.card.discard.DiscardContactEvent;
import com.aplicant.test.client.event.card.save.SaveContactEvent;
import com.aplicant.test.client.event.card.validate.name.ContactValidateNameEvent;
import com.aplicant.test.client.event.card.validate.phone.ContactValidatePhoneEvent;
import com.aplicant.test.shared.model.Contact;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.EventBus;

public class CardViewImpl extends Composite implements CardView {

	private String contactId = null;
	private static CardViewImplUiBinder uiBinder = GWT
			.create(CardViewImplUiBinder.class);
	@UiField TextBox nameField;
	@UiField TextBox phoneField;
	@UiField Button saveButton;
	@UiField Button cancelButton;
	@UiField Button deleteButton;
	@UiField Label nameLabel;
	@UiField Label phoneLabel;
	private EventBus eventBus;

	interface CardViewImplUiBinder extends UiBinder<Widget, CardViewImpl> {
	}

	public CardViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setContact(Contact contact) {
		contactId = contact.id;
		nameField.setText(contact.name);
		phoneField.setText(contact.phone);
	}

	@Override
	public Contact getContact() {
		Contact result = new Contact(nameField.getText(), phoneField.getText());
		result.id = contactId;
		return result;
	}

	@Override
	public void setDeletable(boolean value) {
		deleteButton.setVisible(value);
	}

	@UiHandler("saveButton")
	void onSaveButtonClick(ClickEvent event) {
		eventBus.fireEvent(new SaveContactEvent(getContact()));
	}
	
	@UiHandler("deleteButton")
	void onDeleteButtonClick(ClickEvent event) {
		eventBus.fireEvent(new DeleteContactEvent(getContact()));
	}
	
	@UiHandler("cancelButton")
	void onCancelButtonClick(ClickEvent event) {
		eventBus.fireEvent(new DiscardContactEvent());
	}

	public void nameValidationOk(){
		nameLabel.setStyleName("gwt-Label");
	}
	
	public void nameValidationError(){
		nameLabel.setStyleName("gwt-field-verification-error");
	}
	
	public void phoneValidationOk(){
		phoneLabel.setStyleName("gwt-Label");
	}
	
	public void phoneValidationError(){
		phoneLabel.setStyleName("gwt-field-verification-error");
	}
	
	@UiHandler("nameField")
	void onNameFieldBlur(BlurEvent event) {
		eventBus.fireEvent(new ContactValidateNameEvent(nameField.getText()));
	}
	
	@UiHandler("phoneField")
	void onPhoneFieldBlur(BlurEvent event) {
		eventBus.fireEvent(new ContactValidatePhoneEvent(phoneField.getText()));
	}

	@Override
	public void setEventBus(EventBus bus) {
		this.eventBus = bus; 
	}

}

package com.aplicant.test.client.view.card;

import com.aplicant.test.client.presenter.card.CardPresenter;
import com.aplicant.test.shared.model.Contact;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.user.client.ui.Label;

public class CardViewImpl extends Composite implements CardView {

	private CardPresenter presenter;
	
	private static CardViewImplUiBinder uiBinder = GWT
			.create(CardViewImplUiBinder.class);
	@UiField TextBox nameField;
	@UiField TextBox phoneField;
	@UiField Button saveButton;
	@UiField Button cancelButton;
	@UiField Button deleteButton;
	@UiField Label nameLabel;
	@UiField Label phoneLabel;

	interface CardViewImplUiBinder extends UiBinder<Widget, CardViewImpl> {
	}

	public CardViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setPresenter(Object presenter) {
		this.presenter = (CardPresenter) presenter;
	}

	@Override
	public void setContact(Contact contact) {
		nameField.setText(contact.name);
		phoneField.setText(contact.phone);
	}

	@Override
	public Contact getContact() {
		Contact result = new Contact(nameField.getText(), phoneField.getText());
		return result;
	}

	@Override
	public void setDeletable(boolean value) {
		deleteButton.setVisible(value);
	}

	@UiHandler("saveButton")
	void onSaveButtonClick(ClickEvent event) {
		presenter.save();
	}
	
	@UiHandler("deleteButton")
	void onDeleteButtonClick(ClickEvent event) {
		presenter.delete();
	}
	
	@UiHandler("cancelButton")
	void onCancelButtonClick(ClickEvent event) {
		presenter.discard();
	}
	
	@UiHandler("nameField")
	void onNameFieldBlur(BlurEvent event) {
		if(!presenter.validateName(nameField.getText())){
			nameLabel.setStyleName(".gwt-Label");
		} else {
			nameLabel.setStyleName(".gwt-Label");
		}
	}
	
	@UiHandler("phoneField")
	void onPhoneFieldBlur(BlurEvent event) {
		if(!presenter.validatePhone(phoneField.getText())){
			phoneLabel.setStyleName(".gwt-Label");
		} else {
			phoneLabel.setStyleName(".gwt-Label");
		}
	}
}

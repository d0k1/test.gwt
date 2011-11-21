package com.aplicant.test.client.view.phonebook;

import com.aplicant.test.client.presenter.phonebook.PhonebookPresenter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.dom.client.ClickEvent;

public class PhonebookViewImpl extends Composite implements PhonebookView {

	private PhonebookPresenter presenter;
	
	private static PhonebookViewImplUiBinder uiBinder = GWT
			.create(PhonebookViewImplUiBinder.class);

	interface PhonebookViewImplUiBinder extends
			UiBinder<Widget, PhonebookViewImpl> {
	}

	public PhonebookViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField Button addButton;
	@UiField Button viewButtom;
	@UiField Button deleteButtom;
	@UiField TextBox filterInput;
	@UiField Button clearButton;
	@UiField ListBox contactList;

	public PhonebookViewImpl(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public Widget asWidget(){
		return this;
	}

	@Override
	public void setPresenter(Object presenter) {
		this.presenter = (PhonebookPresenter) presenter;
	}
	
	@Override
	public ListBox getContactListBox(){
		return contactList;
	}
	@UiHandler("contactList")
	void onContactListDoubleClick(DoubleClickEvent event) {
		if(contactList.getSelectedIndex()>=0){
			presenter.updateContact(contactList.getSelectedIndex());
		}
	}
	@UiHandler("viewButtom")
	void onViewButtomClick(ClickEvent event) {
		if(contactList.getSelectedIndex()>=0){
			presenter.updateContact(contactList.getSelectedIndex());
		} else {
			Window.alert("Не выбран контакт в списке контактов");
		}
	}
	@UiHandler("deleteButtom")
	void onDeleteButtomClick(ClickEvent event) {
		if(contactList.getSelectedIndex()>=0){
			presenter.deleteContact(contactList.getSelectedIndex());
		} else {
			Window.alert("Не выбран контакт в списке контактов");
		}
	}
	@UiHandler("addButton")
	void onAddButtonClick(ClickEvent event) {
		presenter.createContact();
	}
}

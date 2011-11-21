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
import com.google.gwt.user.client.ui.ToggleButton;

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
	
	public boolean filtered = false;

	@UiField Button addButton;
	@UiField Button viewButtom;
	@UiField Button deleteButtom;
	@UiField TextBox filterInput;
	@UiField ListBox contactList;
	@UiField ToggleButton filterToggleButton;

	public PhonebookViewImpl(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
		
		filterToggleButton.setDown(false);
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

	public ToggleButton getFilterToggleButton() {
		return filterToggleButton;
	}
	
	@UiHandler("filterToggleButton")
	void onFilterToggleButtonClick(ClickEvent event) {
		if(filtered){
			filterToggleButton.setDown(false);
			filtered = false;
			presenter.unfilterContacts();
		} else {			
			filtered = true;
			filterToggleButton.setDown(true);
			presenter.filterContacts(filterInput.getText());
		}
	}

	@Override
	public boolean getFilterState() {
		return filtered;
	}

	@Override
	public TextBox getFilterInput() {
		return filterInput;
	}

	@Override
	public void setFilterState(boolean value) {
		this.filtered = value;
	}
}

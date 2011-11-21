package com.aplicant.test.client.view.phonebook;

import java.util.ArrayList;

import com.aplicant.test.client.event.phonebook.create.CreateContactEvent;
import com.aplicant.test.client.event.phonebook.delete.DeleteContactEvent;
import com.aplicant.test.client.event.phonebook.filter.FilterContactsEvent;
import com.aplicant.test.client.event.phonebook.unfilter.UnfilterContactsEvent;
import com.aplicant.test.client.event.phonebook.update.UpdateContactEvent;
import com.aplicant.test.shared.model.Contact;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.EventBus;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.DoubleClickEvent;

public class PhonebookViewImpl extends Composite implements PhonebookView {
	private ArrayList<Contact> currentContacts = new ArrayList<Contact>();

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
	@UiField ListBox contactList;
	@UiField Button filterButton;
	@UiField Button unfilterButton;
	private EventBus eventBus;

	public PhonebookViewImpl(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public Widget asWidget(){
		return this;
	}
	
	@Override
	public ListBox getContactListBox(){
		return contactList;
	}

	@Override
	public TextBox getFilterInput() {
		return filterInput;
	}

	@Override
	public HasClickHandlers getAddButton() {
		return addButton;
	}

	@Override
	public HasClickHandlers getDetailsButton() {
		return viewButtom;
	}

	@Override
	public HasClickHandlers getDeleteButton() {
		return deleteButtom;
	}

	@Override
	public HasClickHandlers getFilterButton() {
		return filterButton;
	}

	@Override
	public HasClickHandlers getUnfilterButton() {
		return unfilterButton;
	}

	@Override
	public void setEventBus(EventBus bus) {
		this.eventBus = bus; 
	}

	@UiHandler("addButton")
	void onAddButtonClick(ClickEvent event) {
		eventBus.fireEvent(new CreateContactEvent());
	}
	@UiHandler("contactList")
	void onContactListDoubleClick(DoubleClickEvent event) {
		if(getContactListBox().getSelectedIndex()>=0){
			eventBus.fireEvent(new UpdateContactEvent(currentContacts.get(getContactListBox().getSelectedIndex())));
		}
	}
	@UiHandler("deleteButtom")
	void onDeleteButtomClick(ClickEvent event) {
		if(getContactListBox().getSelectedIndex()>=0){
			eventBus.fireEvent(new DeleteContactEvent(currentContacts.get(getContactListBox().getSelectedIndex())));
		} else {
			Window.alert("Не выбран контакт в списке");
		}
	}
	@UiHandler("viewButtom")
	void onViewButtomClick(ClickEvent event) {
		if(getContactListBox().getSelectedIndex()>=0){
			eventBus.fireEvent(new UpdateContactEvent(currentContacts.get(getContactListBox().getSelectedIndex())));
		} else {
			Window.alert("Не выбран контакт в списке");
		}
	}

	@Override
	public void setData(ArrayList<Contact> data) {
		currentContacts.clear();
		currentContacts.addAll(data);
    	ListBox b = getContactListBox();
    	b.clear();
    	
    	for (Contact item : currentContacts) {
        	b.addItem(item.name);
		}
	}
	@UiHandler("filterButton")
	void onFilterButtonClick(ClickEvent event) {
		eventBus.fireEvent(new FilterContactsEvent(filterInput.getText()));
	}
	
	@UiHandler("unfilterButton")
	void onUnfilterButtonClick(ClickEvent event) {
		eventBus.fireEvent(new UnfilterContactsEvent());
	}
}

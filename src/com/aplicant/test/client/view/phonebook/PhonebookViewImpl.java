package com.aplicant.test.client.view.phonebook;

import com.aplicant.test.client.presenter.phonebook.PhonebookPresenter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

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
}

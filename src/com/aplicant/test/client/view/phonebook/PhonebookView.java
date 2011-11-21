package com.aplicant.test.client.view.phonebook;

import com.aplicant.test.client.view.CommonView;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ToggleButton;

public interface PhonebookView extends CommonView {
	ListBox getContactListBox();
	boolean getFilterState();
	void setFilterState(boolean value);
	TextBox getFilterInput();
}

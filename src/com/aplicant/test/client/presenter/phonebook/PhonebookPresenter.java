package com.aplicant.test.client.presenter.phonebook;

public interface PhonebookPresenter {
	void createContact();
	void updateContact(int index);
	void deleteContact(int index);
	void filterContacts(int index);
}

package com.aplicant.test.client.view.card;

import com.aplicant.test.client.view.CommonView;
import com.aplicant.test.shared.model.Contact;

public interface CardView extends CommonView {
	
	void setContact(Contact contact);
	Contact getContact();
	void setDeletable(boolean value);

	public void nameValidationOk();
	public void nameValidationError();
	public void phoneValidationOk();
	public void phoneValidationError();
}

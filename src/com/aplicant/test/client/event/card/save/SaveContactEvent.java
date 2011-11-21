package com.aplicant.test.client.event.card.save;

import com.aplicant.test.shared.model.Contact;
import com.google.gwt.event.shared.GwtEvent;

public class SaveContactEvent extends GwtEvent<SaveContactHandler> {
	public static Type<SaveContactHandler> TYPE = new Type<SaveContactHandler>();

	private Contact contact;
	
	@Override
	public Type<SaveContactHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(SaveContactHandler handler) {
		handler.onSaveContact(this);
	}
	
	public SaveContactEvent(Contact contact){
		this.contact = contact;
	}
	
	public Contact getContact(){
		return contact;
	}
}

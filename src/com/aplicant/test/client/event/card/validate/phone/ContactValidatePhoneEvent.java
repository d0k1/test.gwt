package com.aplicant.test.client.event.card.validate.phone;

import com.google.gwt.event.shared.GwtEvent;

public class ContactValidatePhoneEvent extends GwtEvent<ContactValidatePhoneHandler> {
	public static Type<ContactValidatePhoneHandler> TYPE = new Type<ContactValidatePhoneHandler>();

	private String phone;
	
	@Override
	public Type<ContactValidatePhoneHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(ContactValidatePhoneHandler handler) {
		handler.onContactValidatePhone(this);
	}

	public ContactValidatePhoneEvent(String phone) {
		super();
		this.phone = phone;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}

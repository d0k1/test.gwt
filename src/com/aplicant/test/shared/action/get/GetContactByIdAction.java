package com.aplicant.test.shared.action.get;

import net.customware.gwt.dispatch.shared.Action;

public class GetContactByIdAction implements Action<GetContactByIdResult> {

	private String contactId;

	public GetContactByIdAction(){
	}

	public GetContactByIdAction(String id){
		this.contactId = id;
	}
	
	public String getContactId() {
		return contactId;
	}

	public void setContactId(String contactId) {
		this.contactId = contactId;
	}
	
}

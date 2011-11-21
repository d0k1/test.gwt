package com.aplicant.test.shared.action.delete;

import net.customware.gwt.dispatch.shared.Action;

import com.aplicant.test.shared.action.get.GetContactsResult;

public class DeleteContactAction  implements Action<DeleteContactResult>{
	private String contactId;

	public DeleteContactAction(){
	}

	public String getContactId() {
		return contactId;
	}

	public void setContactId(String contactId) {
		this.contactId = contactId;
	}
}
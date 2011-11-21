package com.aplicant.test.shared.action.delete;

import net.customware.gwt.dispatch.shared.Action;

public class DeleteContactAction  implements Action<DeleteContactResult>{
	private String contactId;

	public DeleteContactAction(){
	}
	
	public DeleteContactAction(String contactId){
		this.contactId = contactId;
	} 

	public String getContactId() {
		return contactId;
	}

	public void setContactId(String contactId) {
		this.contactId = contactId;
	}
}

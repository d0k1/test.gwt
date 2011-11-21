package com.aplicant.test.shared.action.get;

import net.customware.gwt.dispatch.shared.Action;

public class GetContactsAction implements Action<GetContactsResult> {

	private String filter="";
	
	public GetContactsAction(){
	}
	
	public GetContactsAction(String filter){
		this.filter = filter;
	}

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}
}

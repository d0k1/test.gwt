package com.aplicant.test.server.handlers.get;

import com.aplicant.test.server.storage.ContactDAO;
import com.aplicant.test.shared.action.get.GetContactsAction;
import com.aplicant.test.shared.action.get.GetContactsResult;

import net.customware.gwt.dispatch.server.ActionHandler;
import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.shared.DispatchException;

public class GetContactsHandler implements ActionHandler<GetContactsAction, GetContactsResult> {

	@Override
	public GetContactsResult execute(GetContactsAction arg0,
			ExecutionContext arg1) throws DispatchException {
		
		GetContactsResult result = new GetContactsResult();
		result.setContacts(ContactDAO.getInstance().getContacts(""));
		return result;
	}

	@Override
	public Class<GetContactsAction> getActionType() {
		return GetContactsAction.class;
	}

	@Override
	public void rollback(GetContactsAction arg0, GetContactsResult arg1,
			ExecutionContext arg2) throws DispatchException {
		
	}

}

package com.aplicant.test.server.handlers.get;

import net.customware.gwt.dispatch.server.ActionHandler;
import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.shared.DispatchException;

import com.aplicant.test.server.storage.ContactDAO;
import com.aplicant.test.shared.action.get.GetContactByIdAction;
import com.aplicant.test.shared.action.get.GetContactByIdResult;
import com.aplicant.test.shared.action.get.GetContactsAction;
import com.aplicant.test.shared.action.get.GetContactsResult;
import com.aplicant.test.shared.model.Contact;

public class GetContactByIdHandler implements ActionHandler<GetContactByIdAction, GetContactByIdResult>{

	@Override
	public GetContactByIdResult execute(GetContactByIdAction arg0,
			ExecutionContext arg1) throws DispatchException {
		
		GetContactByIdResult result = new GetContactByIdResult();
		Contact item = ContactDAO.getInstance().getContactById(arg0.getContactId());
		result.setContact(item);
		return result;
	}

	@Override
	public Class<GetContactByIdAction> getActionType() {
		// TODO Auto-generated method stub
		return GetContactByIdAction.class;
	}

	@Override
	public void rollback(GetContactByIdAction arg0, GetContactByIdResult arg1,
			ExecutionContext arg2) throws DispatchException {
		// TODO Auto-generated method stub
		
	}

}

package com.aplicant.test.server.handlers.create;

import net.customware.gwt.dispatch.server.ActionHandler;
import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.shared.DispatchException;

import com.aplicant.test.server.storage.ContactDAO;
import com.aplicant.test.shared.action.create.CreateContactAction;
import com.aplicant.test.shared.action.create.CreateContactResult;
import com.aplicant.test.shared.action.get.GetContactsAction;
import com.aplicant.test.shared.action.get.GetContactsResult;

public class CreateContactHandler implements ActionHandler<CreateContactAction, CreateContactResult>{

	@Override
	public CreateContactResult execute(CreateContactAction arg0,
			ExecutionContext arg1) throws DispatchException {
		
		CreateContactResult result = new CreateContactResult();
		
		ContactDAO.getInstance().addContact(arg0.getContact());
		
		return result;
	}

	@Override
	public Class<CreateContactAction> getActionType() {
		// TODO Auto-generated method stub
		return CreateContactAction.class;
	}

	@Override
	public void rollback(CreateContactAction arg0, CreateContactResult arg1,
			ExecutionContext arg2) throws DispatchException {
		// TODO Auto-generated method stub
		
	}

}

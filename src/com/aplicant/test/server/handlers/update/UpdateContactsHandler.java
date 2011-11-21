package com.aplicant.test.server.handlers.update;

import net.customware.gwt.dispatch.server.ActionHandler;
import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.shared.DispatchException;

import com.aplicant.test.server.storage.ContactDAO;
import com.aplicant.test.shared.action.create.CreateContactAction;
import com.aplicant.test.shared.action.create.CreateContactResult;
import com.aplicant.test.shared.action.update.UpdateContactAction;
import com.aplicant.test.shared.action.update.UpdateContactResult;

public class UpdateContactsHandler implements ActionHandler<UpdateContactAction, UpdateContactResult>{

	@Override
	public UpdateContactResult execute(UpdateContactAction arg0,
			ExecutionContext arg1) throws DispatchException {
		
		UpdateContactResult result = new UpdateContactResult();
		
		ContactDAO.getInstance().updateContact(arg0.getContact());
		
		return result;
	}

	@Override
	public Class<UpdateContactAction> getActionType() {
		// TODO Auto-generated method stub
		return UpdateContactAction.class;
	}

	@Override
	public void rollback(UpdateContactAction arg0, UpdateContactResult arg1,
			ExecutionContext arg2) throws DispatchException {
		// TODO Auto-generated method stub
		
	}

}

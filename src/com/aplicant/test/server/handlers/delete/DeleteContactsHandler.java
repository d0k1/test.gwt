package com.aplicant.test.server.handlers.delete;

import net.customware.gwt.dispatch.server.ActionHandler;
import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.shared.DispatchException;

import com.aplicant.test.server.storage.ContactDAO;
import com.aplicant.test.shared.action.delete.DeleteContactAction;
import com.aplicant.test.shared.action.delete.DeleteContactResult;

public class DeleteContactsHandler implements ActionHandler<DeleteContactAction, DeleteContactResult>{

	@Override
	public DeleteContactResult execute(DeleteContactAction arg0,
			ExecutionContext arg1) throws DispatchException {
		
		DeleteContactResult result = new DeleteContactResult(); 
		ContactDAO.getInstance().deleteContact(arg0.getContactId());
		
		return result;
	}

	@Override
	public Class<DeleteContactAction> getActionType() {
		// TODO Auto-generated method stub
		return DeleteContactAction.class;
	}

	@Override
	public void rollback(DeleteContactAction arg0, DeleteContactResult arg1,
			ExecutionContext arg2) throws DispatchException {
		// TODO Auto-generated method stub
		
	}

}

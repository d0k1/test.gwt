package com.aplicant.test.server.handlers.get;

import net.customware.gwt.dispatch.server.ActionHandler;
import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.shared.DispatchException;

import com.aplicant.test.server.storage.ContactDAO;
import com.aplicant.test.shared.action.get.GetContactByIdAction;
import com.aplicant.test.shared.action.get.GetContactByIdResult;
import com.aplicant.test.shared.model.Contact;

public class GetContactByIdHandler implements ActionHandler<GetContactByIdAction, GetContactByIdResult>{

	@Override
	public GetContactByIdResult execute(GetContactByIdAction arg0,
			ExecutionContext arg1) throws DispatchException {
		
		GetContactByIdResult result = new GetContactByIdResult();
		Contact item = ContactDAO.getInstance().getContactById(arg0.getContactId());
		if(item==null){
			throw new DispatchException() {
			/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

			@Override
			public String getMessage() {
				return "Контакт не найден";
			}
		};
		}
		else {
			result.setContact(item);
			return result;
		}
	}

	@Override
	public Class<GetContactByIdAction> getActionType() {
		
		return GetContactByIdAction.class;
	}

	@Override
	public void rollback(GetContactByIdAction arg0, GetContactByIdResult arg1,
			ExecutionContext arg2) throws DispatchException {
	}

}

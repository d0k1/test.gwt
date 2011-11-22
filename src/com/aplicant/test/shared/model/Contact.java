package com.aplicant.test.shared.model;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Contact implements IsSerializable{
	
	public String id = null;
	public String name;
	public String phone;
	
	public Contact(){
	}
	
	public Contact(String name, String phone){
		this.name = name;
		this.phone = phone;
	}
	
}

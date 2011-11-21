package com.aplicant.test.shared.validate;

public class PhoneFieldVerifier {
	
	public static boolean isValidPhone(String phone){
		if (phone == null) {
			return false;
		}
		
		boolean retval = false;
	    String phoneNumberPattern = "(\\d-)?(\\d{3}-)?\\d{3}-\\d{4}";

	    retval = phone.matches(phoneNumberPattern);

	    return retval;		
	}
}

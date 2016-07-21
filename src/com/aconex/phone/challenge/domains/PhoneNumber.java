package com.aconex.phone.challenge.domains;

import java.util.HashSet;
import java.util.Set;

/**
 * Store the phone number list
 * @author Tommy
 *
 */
public class PhoneNumber  {

	//Phone Number List from the phone file
	private Set<String> phoneNumberSet = new HashSet<String>();

	public Set<String> getPhoneNumberSet() {
		return phoneNumberSet;
	}

	public void setPhoneNumberSet(Set<String> phoneNumberSet) {
		this.phoneNumberSet = phoneNumberSet;
	}
	
	
}

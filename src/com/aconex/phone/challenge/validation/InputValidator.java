package com.aconex.phone.challenge.validation;

/**
 * This is the validator for the phone number 
 * @author Tommy
 *
 */
public class InputValidator {

	/**
	 * Validate the phone number 
	 * @param number
	 */
	public static void validatePhoneNumber(String number) {
		
		for (Character character : number.toCharArray()){
			if (!Character.isDigit(character)) {

				throw new IllegalArgumentException("Invalid characters. The program only accepts digits");
			}
		}
		
	}
	
}

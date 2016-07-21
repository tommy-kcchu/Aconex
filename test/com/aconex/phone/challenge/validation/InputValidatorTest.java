/**
 * 
 */
package com.aconex.phone.challenge.validation;

import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * This is the unit test call for InputValidator
 * @author Tommy
 *
 */
public class InputValidatorTest {

	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testIsDigit() throws IOException {
		
		String number="123456";
		InputValidator.validatePhoneNumber(number);
		assert(true);
	}
	
	@Test
	public void testIsNotDigit() {
		
		String number="12XXXX456";
		thrown.expect(IllegalArgumentException.class);
		InputValidator.validatePhoneNumber(number);
		
		
	}

	@Test
	public void testIsDigitContainedSpace() {
		
		String number="123 456";
		thrown.expect(IllegalArgumentException.class);
		InputValidator.validatePhoneNumber(number);
		
		
	}
	
	@Test
	public void testIsDigitContainedSpecialChar() {
		
		String number="123$$$456";
		thrown.expect(IllegalArgumentException.class);
		InputValidator.validatePhoneNumber(number);
		
	}
	
	@Test
	public void testIsNumberEmpty() {
		
		String number="";
		InputValidator.validatePhoneNumber(number);
			
	}
	
	@Test
	public void testIsNumberNull(){
		
		String number=null;
		thrown.expect(NullPointerException.class);
		InputValidator.validatePhoneNumber(number);
		
		
	}
	
}

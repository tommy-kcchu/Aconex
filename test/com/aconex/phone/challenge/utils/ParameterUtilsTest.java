package com.aconex.phone.challenge.utils;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.aconex.phone.challenge.constants.PhoneConstants;
import com.aconex.phone.challenge.domains.Command;

/**
 * 
 * @author Tommy
 *
 */
public class ParameterUtilsTest {

	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	private Command command = new Command();
	private String[] args = {PhoneConstants.COMMAND_OPTION_D, 
							PhoneConstants.UNIT_TEST_DICTIONARY_PATH, 
							PhoneConstants.UNIT_TEST_PHONE_LIST_PATH};
	
	@Test
	public void testCmdWithAllArgs() throws Exception {
		
		ParameterUtils.retrieveDictionaryPath(args, command);
		assert(true);
				
	}
	
	@Test
	public void testCmdWithOptionAndDirArgs() throws Exception {
		
		Command command = new Command();
		String[] args = {PhoneConstants.COMMAND_OPTION_D, 
						PhoneConstants.UNIT_TEST_DICTIONARY_PATH};
		
		ParameterUtils.retrieveDictionaryPath(args, command);
		assert(true);
	}
	
	@Test
	public void testCmdWithOptionArgs() throws Exception {
		
		Command command = new Command();
		String[] args = {PhoneConstants.COMMAND_OPTION_D};
		thrown.expect(ArrayIndexOutOfBoundsException.class);
		
		ParameterUtils.retrieveDictionaryPath(args, command);
	}
	
	@Test
	public void testCmdWithoutArgsValue() throws Exception {
		
		Command command = new Command();
		String[] args = new String[3];
		thrown.expect(Exception.class);
		ParameterUtils.retrieveDictionaryPath(args, command);
		
	}
	
	@Test
	public void testCmdWithFilePath() throws Exception {
		
		Command command = new Command();
		String[] args = {PhoneConstants.UNIT_TEST_DICTIONARY_PATH};
		thrown.expect(Exception.class);
		ParameterUtils.retrieveDictionaryPath(args, command);
		
	}
	
	@Test
	public void testCmdWithoutArgs() throws Exception {
		
		Command command = new Command();
		String[] args = new String[0];
		thrown.expect(Exception.class);
		ParameterUtils.retrieveDictionaryPath(args, command);
		
	}

	
	//@Test
	public void testDeterminPhoneInputWithAllArgs() {
	
		ParameterUtils.determinPhoneInput(args, command);
		assert(true);
	}

	@Test
	public void testDeterminPhoneInputWithOptionAndDirArgs() {
		
		String[] args = {PhoneConstants.COMMAND_OPTION_D, 
						PhoneConstants.UNIT_TEST_DICTIONARY_PATH};
		
		ParameterUtils.determinPhoneInput(args, command);
		assert(true);
	}
	
	@Test
	public void testDeterminPhoneInputWithOptionArgs() {
		
		String[] args = {PhoneConstants.COMMAND_OPTION_D};
		
		ParameterUtils.determinPhoneInput(args, command);
		assert(true);
	}
	
	@Test
	public void testDeterminPhoneInputWithoutArgsValue() {
		
		Command command = new Command();
		String[] args = new String[3];
		
		ParameterUtils.determinPhoneInput(args, command);
		assert(true);
	}
	
	@Test
	public void testDeterminPhoneInputWithoutArgs() {
		
		Command command = new Command();
		String[] args = new String[0];
		
		ParameterUtils.determinPhoneInput(args, command);
		assert(true);
	
	}
	
	@Before
	public void setUp() throws Exception {
		
		command.setDictionaryPath(PhoneConstants.UNIT_TEST_DICTIONARY_PATH);
		
	}


}

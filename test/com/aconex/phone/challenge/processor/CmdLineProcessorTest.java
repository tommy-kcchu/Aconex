package com.aconex.phone.challenge.processor;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.aconex.phone.challenge.constants.PhoneConstants;
import com.aconex.phone.challenge.domains.Command;
import com.aconex.phone.challenge.domains.Dictionary;
import com.aconex.phone.challenge.utils.FileUtils;

public class CmdLineProcessorTest {

	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	private Command command = new Command();
	private Dictionary dictionary = new Dictionary();
	private CmdLineProcessor cmdLineProcessor = new CmdLineProcessor();
	
	@Test
	public void testValidPhoneNumber() throws IOException {
		
		String phone = "2255.63";
		List<String> expectedList = new ArrayList<String>();
		
		Map<String, List<String>> result = cmdLineProcessor.processPhoneNumberWithDictionary(Arrays.asList(phone), dictionary);
		/**
		All possible words  for 2255.63 are: 
			AAJJ-ME
			CALL-ME
		*/
		expectedList.add("AAJJ-ME");
		expectedList.add("CALL-ME");
		List<String> resultList =  retrieveResultList(result);
		
		assertEquals(expectedList.size(), resultList.size());
		expectedList.removeIf(exp -> resultList.contains(exp));
		assertEquals(0, expectedList.size());			
	}
	
	@Test
	public void testPhoneNumberWithSpecialChar() throws IOException {
		
		String phone = "22&&55.63";
		List<String> expectedList = new ArrayList<String>();
		
		Map<String, List<String>> result = cmdLineProcessor.processPhoneNumberWithDictionary(Arrays.asList(phone), dictionary);
		/**
		All possible words  for 22&&55.63 are: 
			22-55-ME
		*/
		expectedList.add("22-55-ME");
		List<String> resultList =  retrieveResultList(result);
		
		assertEquals(expectedList.size(), resultList.size());
		expectedList.removeIf(exp -> resultList.contains(exp));
		assertEquals(0, expectedList.size());			
	}
	
	@Test
	public void testPhoneNumberStartWithLetter() throws IOException {
		
		String phone = "a123456";
		List<String> expectedList = new ArrayList<String>();
		
		Map<String, List<String>> result = cmdLineProcessor.processPhoneNumberWithDictionary(Arrays.asList(phone), dictionary);
		/**
		All possible words  for a123456 are: 
			123456
		*/
		expectedList.add("123456");
		List<String> resultList =  retrieveResultList(result);
		
		assertEquals(expectedList.size(), resultList.size());
		expectedList.removeIf(exp -> resultList.contains(exp));
		assertEquals(0, expectedList.size());			
	}
	
	@Test
	public void testPhoneNumberWithoutMatch() throws IOException {
		
		String phone = "1111";
		List<String> expectedList = new ArrayList<String>();
		
		Map<String, List<String>> result = cmdLineProcessor.processPhoneNumberWithDictionary(Arrays.asList(phone), dictionary);
		/**
		The result should be 1111 since no match in the dictionary
		*/
		
		expectedList.add("1111");
		List<String> resultList =  retrieveResultList(result);
		
		assertEquals(expectedList.size(), resultList.size());
		expectedList.removeIf(exp -> resultList.contains(exp));
		assertEquals(0, expectedList.size());			
	}
	
	@Test
	public void testValidPhoneNumberWithSpace() throws IOException {
		
		String phone = "2 2 5 5.6   3   ";
		List<String> expectedList = new ArrayList<String>();
		
		Map<String, List<String>> result = cmdLineProcessor.processPhoneNumberWithDictionary(Arrays.asList(phone), dictionary);
		/**
		All possible words  for 2255.63 are: 
			AAJJ-ME
			CALL-ME
		*/
		expectedList.add("AAJJ-ME");
		expectedList.add("CALL-ME");
		List<String> resultList =  retrieveResultList(result);
		
		assertEquals(expectedList.size(), resultList.size());
		expectedList.removeIf(exp -> resultList.contains(exp));
		assertEquals(0, expectedList.size());			
	}
	
	private static List<String> retrieveResultList(Map<String, List<String>> oResults) {
		Set<String> keySet = oResults.keySet();
		List<String> oValues = new ArrayList<String>();
		for (String key : keySet) {
			oValues = oResults.get(key);
		}
		
		return oValues;
	}
	
	@Before
	public void setUp() throws Exception {
		
		command.setDictionaryPath(PhoneConstants.UNIT_TEST_DICTIONARY_PATH);
		command.setPhoneNumberPath(PhoneConstants.UNIT_TEST_PHONE_LIST_PATH);
		
		dictionary = FileUtils.dictionaryReader(command);
		
		
	}

	
}

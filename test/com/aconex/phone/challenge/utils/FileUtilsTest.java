package com.aconex.phone.challenge.utils;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.aconex.phone.challenge.constants.PhoneConstants;
import com.aconex.phone.challenge.domains.Command;
import com.aconex.phone.challenge.domains.Dictionary;
import com.aconex.phone.challenge.domains.PhoneNumber;

public class FileUtilsTest {

	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	private Command command = new Command();
	
	@Test
	public void testDictionaryFileFound() throws IOException {
		
		FileUtils.dictionaryReader(command);
		assert(true);
		
	}
	
	@Test
	public void testDictionaryFileNotFound() throws IOException {
		thrown.expect(IOException.class);
		Command command= new Command();
		command.setDictionaryPath("test.txt");
		FileUtils.dictionaryReader(command);
				
	}
	
	@Test
	public void testDictionaryPathEmpty() throws IOException {
		thrown.expect(IOException.class);
		Command command= new Command();
		command.setDictionaryPath("");
		FileUtils.dictionaryReader(command);
				
	}

	@Test
	public void testPhoneFileFound() throws IOException {
		
		FileUtils.retrievePhoneListFromFile(PhoneConstants.UNIT_TEST_PHONE_LIST_PATH);
		assert(true);
				
	}
	
	@Test
	public void testPhoneFileNotFound() throws IOException {
		
		thrown.expect(IOException.class);
		FileUtils.retrievePhoneListFromFile("test.txt");
				
	}
	
	@Test
	public void testPhonePathEmpty() throws IOException {
		
		FileUtils.retrievePhoneListFromFile("");
				
	}

	@Test
	public void testDictionaryReaderFilteredUpperWords() throws IOException {
		
		Dictionary dictionary = FileUtils.dictionaryReader(command);
		List<String> expectedList = new ArrayList<String>();
		expectedList.add("CALL");
		expectedList.add("FLOWERS");
		expectedList.add("CODING");
		expectedList.add("ACONEX");
		expectedList.add("MEM");
		expectedList.add("AAJJ");
		expectedList.add("133SS");
		expectedList.add("ME");
		expectedList.add("HELLO");
		expectedList.add("ANGEL");
		
		List<String> resultList = new ArrayList<String>();
		dictionary.getDictionarySet().forEach(word -> resultList.add(word));
		
		assertEquals(expectedList.size(), resultList.size());
		expectedList.removeIf(exp -> resultList.contains(exp));
		assertEquals(0, expectedList.size());			
		
				
	}
	
	@Test
	public void testRetrievePhoneListFromFile() throws IOException {
		PhoneNumber phoneNumber = new PhoneNumber();
		
		phoneNumber = FileUtils.retrievePhoneListFromFile(command.getPhoneNumberPath());
		List<String> expectedList = new ArrayList<String>();
		expectedList.add("2255.63");
		expectedList.add("2244$$.1234");
		expectedList.add("2255-11134");
		expectedList.add("2255.64");
	
		List<String> resultList = new ArrayList<String>();
		phoneNumber.getPhoneNumberSet().forEach(phone -> resultList.add(phone));
		
		assertEquals(expectedList.size(), resultList.size());
		expectedList.removeIf(exp -> resultList.contains(exp));
		assertEquals(0, expectedList.size());			
		
		
	}
	
	
	
	
	@Before
	public void setUp() throws Exception {
		
		command.setDictionaryPath(PhoneConstants.UNIT_TEST_DICTIONARY_PATH);
		command.setPhoneNumberPath(PhoneConstants.UNIT_TEST_PHONE_LIST_PATH);
		
	}

	

}

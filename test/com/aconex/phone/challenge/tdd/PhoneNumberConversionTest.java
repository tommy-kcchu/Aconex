package com.aconex.phone.challenge.tdd;

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
import com.aconex.phone.challenge.utils.FileUtils;

public class PhoneNumberConversionTest {

	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	private Dictionary dictionary = new Dictionary();
	private Command command = new Command();
	
	@Test
	public void testPhoneNumberConversion() throws IOException {
		
		String phone = "2255";
		List<String> wordList = new ArrayList<String>();
		convertPhoneNumber(phone,dictionary,wordList);
		assert(true);
		
	}
	
	@Test
	public void testInvalidPhoneNumberConversion() throws IOException {
		
		String phone = "22xxx";
		thrown.expect(ArrayIndexOutOfBoundsException.class);
		List<String> wordList = new ArrayList<String>();
		convertPhoneNumber(phone,dictionary,wordList);

	}
	
	@Test
	public void testInvalidPhoneNumberConversion2() throws IOException {
		
		String phone = "22 11.11";
		thrown.expect(ArrayIndexOutOfBoundsException.class);
		List<String> wordList = new ArrayList<String>();
		convertPhoneNumber(phone,dictionary,wordList);

	}
	
	@Test
	public void testInvalidPhoneNumberConversion3() throws IOException {
		
		String phone = "a2211.13";
		thrown.expect(ArrayIndexOutOfBoundsException.class);
		List<String> wordList = new ArrayList<String>();
		convertPhoneNumber(phone,dictionary,wordList);

	}
	
	
	
	/**
	 * Convert the phone number to character array
	 * @param number
	 * @param dictionary
	 * @param wordList
	 */
	private static void convertPhoneNumber(String number, Dictionary dictionary, List<String> wordList) {
		
		int[] intArray = new int[number.length()];

		for (int i = 0; i < number.length(); i++) {
		    intArray[i] = Character.digit(number.charAt(i), 10);
		}
		//Place holder for the program 
		char[] output = new char[intArray.length];
		
	    dictionaryLookup(intArray,0,output,dictionary,wordList);
	}

	/**
	 * Use recursive to search the dictionary based on the converted phone number
	 * @param number
	 * @param currentIndex
	 * @param output
	 * @param dictionary
	 * @param wordList
	 */
	private static void dictionaryLookup(int[] number, int currentIndex, char[] output, Dictionary dictionary,List<String> wordList) {
	    // Check if the current word search is done
	    if (currentIndex == output.length) {
	        
	        String result = String.valueOf(output);
	        /**
	         * check if the word is found in the dictionary
	         */
	        if(dictionary.getDictionarySet().contains(result)){
	        	 wordList.add(result);
	        }
	        return;
	    }

	    /**
	     * 1. Find the phone pad mapping based on a character
	     * 2. Convert the number with all possible characters
	     *  
	     */
	 
	    char currentPhoneKey[] = PhoneConstants.PHONE_KEYPADS[number[currentIndex]].toCharArray();
	    for (int i = 0; i< currentPhoneKey.length ; i++) {
	        output[currentIndex] = currentPhoneKey[i];
	        dictionaryLookup(number, currentIndex+1, output,dictionary,wordList);
	        if (number[currentIndex] <= 1){
	        	return;
	        }
	            
	    }
	}
	
	@Before
	public void setUp() throws Exception {
		command.setDictionaryPath(PhoneConstants.UNIT_TEST_DICTIONARY_PATH);
		command.setPhoneNumberPath(PhoneConstants.UNIT_TEST_PHONE_LIST_PATH);
		
		dictionary = FileUtils.dictionaryReader(command);
	}

}

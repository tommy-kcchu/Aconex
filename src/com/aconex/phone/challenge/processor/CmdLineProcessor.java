package com.aconex.phone.challenge.processor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aconex.phone.challenge.constants.PhoneConstants;
import com.aconex.phone.challenge.domains.Dictionary;
import com.aconex.phone.challenge.validation.InputValidator;

/**
 * This is the processor to handle the command line operations.
 * @author Tommy
 *
 */
public class CmdLineProcessor extends BaseProcessor{

	@Override
	public Map<String, List<String>> processPhoneNumberWithDictionary(List<String> phoneNumberList, Dictionary dictionary) {
		
		return processPhoneNumber(phoneNumberList,dictionary);
	
	}
	
	private Map<String, List<String>> processPhoneNumber(List<String> phoneNumberList, Dictionary dictionary) {
		
		Map<String, List<String>> resultMap = new HashMap<String, List<String>>();
		
		for (String phoneNumber : phoneNumberList) {
			//Trim all spaces and split by non digit for matching
			String[] phoneNumberArr = phoneNumber.replaceAll(PhoneConstants.REGEX_SPACE, "").split(PhoneConstants.REGEX_NON_DIGIT);
			List<String> combinedList = Arrays.asList("");
			for (String number : phoneNumberArr) {
				//Validate the number
				InputValidator.validatePhoneNumber(number);
				List<String> wordList = new ArrayList<String>();
				//Search the dictionary list with the phone number
				convertPhoneNumber(number, dictionary, wordList);
				//cannot find the word in the dictionary, leave it as it is
				if(wordList.isEmpty()){
					wordList.add(number);
				}
				//Store the list and combine later
				combinedList = combineResult(combinedList, wordList);
				
			}
			//Create a map with the combined word list
			resultMap.put(phoneNumber, combinedList);
		}
		return resultMap;
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
	 * Use recursion to search the dictionary based on the converted phone number
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
	
	
	/**
	 * Store and combine the elements after the words are mapped
	 * e.g. 2255.63
	 * 1. 2255 is left
	 * 2. 63 is right 
	 * @param left
	 * @param right
	 * @return
	 */
	private List<String> combineResult(List<String> left, List<String> right) {
		List<String> resultList = new ArrayList<String>();
		for (String leftWord : left) {
			for (String rightWord : right) {
				if (leftWord.isEmpty()) {
					resultList.add(rightWord.toUpperCase());
				} else {
					resultList.add(leftWord + PhoneConstants.BOUNDARY_DASH + rightWord.toUpperCase());
				}
			}
		}
		return resultList;
	}


}

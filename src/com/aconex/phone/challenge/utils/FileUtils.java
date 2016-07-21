package com.aconex.phone.challenge.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import com.aconex.phone.challenge.constants.PhoneConstants;
import com.aconex.phone.challenge.domains.Command;
import com.aconex.phone.challenge.domains.Dictionary;
import com.aconex.phone.challenge.domains.PhoneNumber;

public class FileUtils {
		
	/**
	 * Use the provided phone list to find the match from the dictionary
	 * @param phoneListPath
	 * @return
	 * @throws IOException
	 */
	public static PhoneNumber retrievePhoneListFromFile(String phoneListPath) throws IOException {
		//Avoid duplicate phone
		Set<String> phoneNumberSet = new HashSet<String>(); 
		PhoneNumber phoneNumber = new PhoneNumber();
		if (phoneListPath == null || phoneListPath.equals(PhoneConstants.EMPTY_STR)) {
			phoneListPath = PhoneConstants.DEFAULT_PHONE_LIST_PATH;
		}
		
		//read file into stream, try-with-resources
		try (Stream<String> stream = Files.lines(Paths.get(phoneListPath))) {
			
			stream
	        	.filter(line -> !line.isEmpty())
	        	.map(String::trim)
	        	.forEach(eachLine -> phoneNumberSet.add(eachLine));
			
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("Unable to find the file '" + phoneListPath  + "' ");
			//System.err.println("Unable to find the file  " + phoneListPath);
			//throw e;	
		} catch (IOException e) {
		
			throw new IOException("Unable to find the file '" + phoneListPath  + "' ");
		}
		
		phoneNumber.setPhoneNumberSet(phoneNumberSet);
		
		return phoneNumber;
		
	}
	
	
	
	public static Dictionary dictionaryReader(Command command) throws IOException  {
		//Avoid duplicate phone
		Set<String> dictionarySet = new HashSet<String>();
		Dictionary dictionary = new Dictionary();
		String dictionaryPath = command.getDictionaryPath();
		
		//read file into stream, try-with-resources
		try (Stream<String> stream = Files.lines(Paths.get(dictionaryPath))) {
			
			stream
	        	.filter(word -> !word.isEmpty())
	        	 .forEach(eachWord -> dictionarySet.add(eachWord.replaceAll("[^a-zA-Z0-9]", "").toUpperCase()));
			
		} catch (FileNotFoundException e) {
			
			throw new FileNotFoundException("Unable to find the file '" + dictionaryPath  + "' ");
			//System.err.println("Unable to find the file  " + dictionaryPath);
			//throw e;
		} catch (IOException e) {
			
			throw new IOException("Unable to find the file '" + dictionaryPath  + "'");
			
		}
		
		dictionary.setDictionarySet(dictionarySet);
			
		return dictionary;

	}
	
	

}

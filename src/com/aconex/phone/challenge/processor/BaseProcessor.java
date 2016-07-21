package com.aconex.phone.challenge.processor;

import java.util.List;
import java.util.Map;

import com.aconex.phone.challenge.domains.Dictionary;

public abstract class BaseProcessor {

	/**
	 * Handle the process to match the converted digits with the words in the dictionary
	 * @param phoneNumberList
	 * @param dictionary
	 * @return
	 */
	public abstract Map<String, List<String>> processPhoneNumberWithDictionary(List<String> phoneNumberList, Dictionary dictionary);
	
	
}

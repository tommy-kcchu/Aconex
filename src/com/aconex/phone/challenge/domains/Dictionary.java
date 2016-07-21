package com.aconex.phone.challenge.domains;

import java.util.HashSet;
import java.util.Set;

/**
 * Store all the words from the dictionary
 * @author Tommy
 *
 */
public class Dictionary {
	
	//Store the words without duplication by using Set
	private Set<String> dictionarySet = new HashSet<String>();

	public Set<String> getDictionarySet() {
		return dictionarySet;
	}

	public void setDictionarySet(Set<String> dictionarySet) {
		this.dictionarySet = dictionarySet;
	}

	
	
}

package com.aconex.phone.challenge.domains;

/**
 * Store all the input parameters
 * @author Tommy
 *
 */
public class Command {

	//Dictionary Path
	private String dictionaryPath;
	
	//Phone Number Path
	private String phoneNumberPath;
	
	//Determine if the application should read from file
	private boolean readFromFile;

	public String getDictionaryPath() {
		return dictionaryPath;
	}

	public void setDictionaryPath(String dictionaryPath) {
		this.dictionaryPath = dictionaryPath;
	}

	public String getPhoneNumberPath() {
		return phoneNumberPath;
	}

	public void setPhoneNumberPath(String phoneNumberPath) {
		this.phoneNumberPath = phoneNumberPath;
	}

	public boolean isReadFromFile() {
		return readFromFile;
	}

	public void setReadFromFile(boolean readFromFile) {
		this.readFromFile = readFromFile;
	}
	
	
}

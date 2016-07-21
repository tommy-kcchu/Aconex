package com.aconex.phone.challenge.constants;

/**
 * Constants used by the application
 * @author Tommy
 *
 */
public class PhoneConstants {
	
	//Default System Dictionary
	public final static String SYSTEM_DICTIONARY_PATH = "data/dictionary/dictionary.txt";
	
	//For Junit Test
	public final static String UNIT_TEST_DICTIONARY_PATH = "data/dictionary/testDictionary.txt";
	
	//Phone Number List
	public final static String DEFAULT_PHONE_LIST_PATH = "data/phone/default.txt";
	//For Junit Test - Phone Number List
	public final static String UNIT_TEST_PHONE_LIST_PATH = "data/phone/testDefault.txt";
	
	//Command Option -d
	public final static String COMMAND_OPTION_D = "-d";
	
	//Command Exit
	public final static String COMMAND_EXIT = "EXIT";

	//Key Pad Setting
	public final static String[] PHONE_KEYPADS = new String[]{"0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};

	//Empty String
	public final static String EMPTY_STR = "";
		
	//Boundary Dash
	public final static String BOUNDARY_DASH = "-";
	
	public final static String REGEX_SPACE = "\\s+";
	
	public final static String REGEX_NON_DIGIT = "\\D+";
	
	public final static String NO_COMMAND_PROVIDED = "No command line arguments are provided. The program will be terminated.\n";
	 /**
     * Usage instructions.
     */
	public final static String INST_WITH_PHONE_NUMBER = "Running with a dictionary and phone number file, you can execute the following command \nwhere <<DIRECTORY_PATH>> is your dictionary path and <<PHONE_NUMBER_PATH>> is the location of your phone number list \n";
	public final static String USAGE_INST_WITHOUT_PHONE_NUMBER = "USAGE: java -jar AconexPhoneChallenge.jar  -d <<DIRECTORY_PATH>>\n";
	public final static String INST_WITHOUT_PHONE_NUMBER = "Running without phone number file, the program will prompt user to get the phone number from STDIN:\n";
	public final static String USAGE_INST_WITH_PHONE_NUMBER = "USAGE: java -jar AconexPhoneChallenge.jar  -d <<DIRECTORY_PATH>> <<PHONE_NUMBER_PATH>>\n";
	
	/**
	 * Error Messages
	 * 
	 */
	public final static String ERR_MSG_CHECK_ARGS = "Please check your parameters before executing this program again.\n";
		
}

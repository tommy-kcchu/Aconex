package com.aconex.phone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import com.aconex.phone.challenge.constants.PhoneConstants;
import com.aconex.phone.challenge.domains.Command;
import com.aconex.phone.challenge.domains.Dictionary;
import com.aconex.phone.challenge.domains.PhoneNumber;
import com.aconex.phone.challenge.processor.CmdLineProcessor;
import com.aconex.phone.challenge.processor.FileProcessor;
import com.aconex.phone.challenge.utils.FileUtils;
import com.aconex.phone.challenge.utils.ParameterUtils;

/**
 * This is the main class to start the application
 * @author Tommy
 *
 */
public class PhoneChallenge {

	public static void main(String[] args) {
		
		Command command = new Command();
	
		try {
			// Read Arguments
			ParameterUtils.retrieveDictionaryPath(args, command);
			
			// Determine if the application reads from files or STDIN when no files are given
			ParameterUtils.determinPhoneInput(args, command);
						
			// Build dictionary object
			Dictionary dictionary = FileUtils.dictionaryReader(command);
			
			if (command!=null && !command.isReadFromFile()){
				
				processCmdInput(dictionary);
				
			}else{
				
				PhoneNumber phoneNumber = FileUtils.retrievePhoneListFromFile(command.getPhoneNumberPath());
				processFile(dictionary,phoneNumber);
			}
				
		} catch (Exception e) {
			
			System.out.println("Exeception: " + e.getMessage());
			System.exit(-1);
		}
		
	}
	
	/**
	 * Process commandline logics
	 * @param dictionary
	 */
	private static void processCmdInput(Dictionary dictionary) {
        
        Scanner scanner = new Scanner(System.in);
		try {
			CmdLineProcessor cmdLineProcessor = new CmdLineProcessor();
			String sLine = null;
			System.out.println("START:: Phone Number Converter.");
			System.out.println("(Please type " + PhoneConstants.COMMAND_EXIT + " if you want to exit this program.)\n");
			while (true) {
				System.out.print("Input number: ");
				sLine = scanner.nextLine().trim();

				if (PhoneConstants.COMMAND_EXIT.equalsIgnoreCase(sLine)) {
					// End the application.
					System.out.println("Exit the program");
					break;
				} else {
					
					Map<String, List<String>> result = cmdLineProcessor.processPhoneNumberWithDictionary(Arrays.asList(sLine), dictionary);
					if (!result.isEmpty()){
						displayResult(result);
					}
					
				}
			}
		} finally {
			scanner.close();
		}
        

	}

	/**
	 * Process the file based logics
	 * @param dictionary
	 * @param phoneNumber
	 */
	private static void processFile(Dictionary dictionary,PhoneNumber phoneNumber) {
		
		FileProcessor fileProcessor = new FileProcessor();
		List<String> phoneList = phoneNumber.getPhoneNumberSet().stream().collect(Collectors.toList());
		Map<String, List<String>> result = fileProcessor.processPhoneNumberWithDictionary(phoneList, dictionary);
		if (!result.isEmpty()){
			displayResult(result);
		}
		
	}
	
	
	/**
	 * Displays the results
	 * 
	 * @param resultList
	 *  
	 */
	private static void displayResult(Map<String, List<String>> resultList) {
		System.out.println("------------------------------------------------------");
		System.out.println("Displaying all possible phone numbers in the directory");
		System.out.println("------------------------------------------------------");
		Set<String> keySet = resultList.keySet();
		List<String> valueList = new ArrayList<String>();
		for (String key : keySet) {
			valueList = resultList.get(key);
			if (valueList.size() > 1) {
				
				System.out.println("List of possible words for " + key + " are the following : ");
				
				valueList.forEach(System.out::println);
			
			} else if (valueList.size() == 1) {
				
				System.out.println("The result for " + key + " is: " + valueList.get(0));
			
			} else {
				
				System.out.println("No words were found in the sequence: " + key);
			}
			
			System.out.println("-------------------------------------------");
		}
	}
	
}

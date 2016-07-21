package com.aconex.phone.challenge.utils;

import com.aconex.phone.challenge.constants.PhoneConstants;
import com.aconex.phone.challenge.domains.Command;

/**
 * This is an utils class to set information into the object
 * 
 * @author Tommy
 *
 */
public class ParameterUtils {

	/**
	 * Check the arguements in the command line
	 * @param args
	 * @param command
	 * @throws Exception 
	 */
	public static void retrieveDictionaryPath(String[] args, Command command) throws Exception{
		String dictionaryPath = null;
		boolean validCmdOpt = false;
		
		if (args.length > 0) {
			//Check parameter if contains -d
			for(int i =0; i < args.length; i++){
				String arg = args[i];
				
				if(arg!=null && arg.equals(PhoneConstants.COMMAND_OPTION_D)){
					try{
						// Retrieve the dictionary path from command line
						dictionaryPath = args[i+1];
						validCmdOpt = true;
						break;
					}catch(ArrayIndexOutOfBoundsException arrIdxEx){
						//only command option -d presented without the actual directory path
						throw arrIdxEx;
						//arrIdxEx.printStackTrace();
					}catch(Exception e){
						throw e;
					}
					
				}
				
			}
			
			if (dictionaryPath==null && !validCmdOpt){
				throw new Exception(PhoneConstants.ERR_MSG_CHECK_ARGS);
			}else{
				command.setDictionaryPath(dictionaryPath);
			}
			
		}else{
			
			System.out.println(PhoneConstants.INST_WITHOUT_PHONE_NUMBER);
			System.out.println(PhoneConstants.USAGE_INST_WITHOUT_PHONE_NUMBER);
			System.out.println(PhoneConstants.INST_WITH_PHONE_NUMBER);
			System.out.println(PhoneConstants.USAGE_INST_WITH_PHONE_NUMBER);
			
			throw new Exception(PhoneConstants.NO_COMMAND_PROVIDED);
			
		}
	
	}
	
	/**
	 * Determine if the program uses default phone number list or prompt for output
	 * @param args
	 * @param command
	 */
	public static void determinPhoneInput(String[] args, Command command){
		
		String dictionaryPath = command.getDictionaryPath();
		
		if(dictionaryPath!=null && args.length == 3){
			//-d <<DIRECTORY_PATH>> <<PHONE_PATH>> are given
			command.setReadFromFile(true);
			command.setPhoneNumberPath(args[2]);
			
		}else if(dictionaryPath!=null && args.length == 2){
			//-d <<DIRECTORY_PATH>> are given
			command.setReadFromFile(false);
		}else{
			
			/* Just start the program without arguments
			 * Assume that the user would like to use default dictionary and phone number list
			 */
			command.setReadFromFile(false);
		}
	}
	

}

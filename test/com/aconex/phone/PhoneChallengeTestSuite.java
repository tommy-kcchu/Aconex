package com.aconex.phone;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.aconex.phone.challenge.processor.CmdLineProcessorTest;
import com.aconex.phone.challenge.processor.FileProcessorTest;
import com.aconex.phone.challenge.tdd.PhoneNumberConversionTest;
import com.aconex.phone.challenge.utils.FileUtilsTest;
import com.aconex.phone.challenge.utils.ParameterUtilsTest;
import com.aconex.phone.challenge.validation.InputValidatorTest;


/**
 * This is the test suite for phone challenge program
 * @author User
 *
 */
@RunWith(Suite.class)
@SuiteClasses({
				InputValidatorTest.class,
				ParameterUtilsTest.class,
				FileUtilsTest.class,
				CmdLineProcessorTest.class,
				FileProcessorTest.class,
				PhoneNumberConversionTest.class
			  })
public class PhoneChallengeTestSuite {

}

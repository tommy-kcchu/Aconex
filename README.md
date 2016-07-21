#Prerequisite#
  
* Java 1.8 
* Eclipse
* Apache Ant
* Junit 4.0


# Building #

Build using ant:

    ant jar
    The default dictionary file will be copied to the build directory and packaged with classes together as a jar file.

# Source Code #
1. Extract AconexCodingChallenge.zip to a new folder.
2. Check if JAVA 8 is installed by typing "java -version' in windows/linux command prompt.
3. Open Eclipse and import the source code from new folder
4. Left-click build.xml (default target is clean-build) to build the source file into a jar file and place it in dist folder.
5. For generating junit report, please change the build target to "clean-build-junit" for the report based on the junit test.
6. The junit report is in junitreport folder.

# How to execute on command prompt#
    
Running without phone number file, the program will prompt user to get the phone number from STDIN where <DIRECTORY_PATH> is your dictionary path:

    java -jar AconexPhoneChallenge.jar -d <DIRECTORY_PATH>

Running with a dictionary and phone number file, you can execute the following command 
where <DIRECTORY_PATH> is your dictionary path and <PHONE_NUMBER_PATH> is the location of your phone number list 

    java -jar AconexPhoneChallenge.jar -d <DIRECTORY_PATH> <PHONE_NUMBER_PATH>
 
# Junit Test # 

Junit test cases are placed in test directory. It covers the following:

* Reading the text files
* Manipulating the string
* Comparing and replacing the string
* Handling errors

# TDD Test #

I wrote a testing class to test the implementation of converting and replacing string before starting the actual program. 

/test/com/aconex/phone/challenge/tdd/PhoneNumberConversionTest.java


 
	   

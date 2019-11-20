package main;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The ProviderData class stores personal information of ChocAn Providers.
 * Inherits attributes and methods from the PersonData Class.
 * @author Erik Jones
 */
public class ProviderData extends PersonData{
	/**
	 * The unique number assigned to each provider
	 */
	private String providerNumber;
	
	/**
	 * Scanner that will be called if the user needs to re-input parameters
	 */
	Scanner scanner = new Scanner(System.in);
	
	/** 
	 * Regex equation used to check if a String contains only numbers
	*/
	Pattern onlyNums = Pattern.compile("[0-9]+");
	Matcher numsMatch;
	
	/**
	 * Default contructor with no paramters
	 */
	public ProviderData() {
		super();
	}
	
	/**
	 * Parameterized constructor
	 * @param providerNumber unique number assigned to each provider
	 * @param name inherited from PersonData class
	 * @param street inherited from PersonData class
	 * @param city inherited from PersonData class
	 * @param state inherited from PersonData class
	 * @param ZIP inherited from PersonData class
	 */
	public ProviderData(String providerNumber, String name, String street, String city, String state, String ZIP) {
		super(name, street, city, state, ZIP);
		setProviderNumber(providerNumber);
	}
	
	/**
	 * getter for providerNumber
	 * @return providerNumber of the given instance
	 */
	public String getProviderNumber() {
		return providerNumber;
	}
	/**
	 * setter for providerNumber
	 * will prompt user to re-enter if given value isn't in the correct format
	 * @param providerNumber the value providerNumber is to be set to
	 */
	public void setProviderNumber(String providerNumber) {
		while(true) {
			numsMatch = onlyNums.matcher(providerNumber);
			if(providerNumber.length() != 9 || numsMatch.matches() == false) {
				System.out.print("Invalid provider number, please enter a valid provider number: ");
				providerNumber = scanner.nextLine();
			}
			else
				break;
		}
		this.providerNumber = providerNumber;
	}
}

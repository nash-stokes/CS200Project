package cs200team4.project4.erik;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProviderData extends PersonData{
	private String providerNumber;
	private ServiceData providerServiceList[];
	
	Scanner scanner = new Scanner(System.in); //Scanner used to allow user to re-input fields 
	
	//Use these to validate a string has only numbers
	Pattern onlyNums = Pattern.compile("[0-9]+");
	Matcher numsMatch;
	
	public ProviderData() {
		super();
	}
	
	public ProviderData(String providerNumber, String name, String street, String city, String state, String ZIP) {
		super(name, street, city, state, ZIP);
		setProviderNumber(providerNumber);
	}
	
	public String getProviderNumber() {
		return providerNumber;
	}

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

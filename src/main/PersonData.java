package main;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

public class PersonData {
	private String name;
	private String street;
	private String city;
	private String state;
	private String ZIP;
	private ArrayList<ServiceData> serviceList = new ArrayList<ServiceData>(); //List of services for each member/provider
	
	Scanner scanner = new Scanner(System.in); //Scanner used to allow user to re-input fields 
	
	//Use these to validate a string has only letters and spaces
	Pattern onlyLetters = Pattern.compile("^[ A-Za-z]+$");
	Matcher lettersMatch;
	
	//Use these to validate a string has only numbers
	Pattern onlyNums = Pattern.compile("[0-9]+");
	Matcher numsMatch;
	
	public PersonData() {
		//Default Constructor
	}
	
	public PersonData(String name, String street, String city, String state, String ZIP) {
		setName(name);
		setStreet(street);
		setCity(city);
		setState(state);
		setZIP(ZIP);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		while(true) {
			lettersMatch = onlyLetters.matcher(name);
			if(name.length() > 25 || lettersMatch.matches() == false) {
				System.out.print("Invalid name, please enter a valid name: ");
				name = scanner.nextLine();
			}
			else
				break;
		}
		this.name = name;
	}
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		while(street.length() > 25) {
			System.out.print("Invalid street address, please enter a valid address: ");
			street = scanner.nextLine();
		}
		this.street = street;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		while(true) {
			lettersMatch = onlyLetters.matcher(city);
			if(city.length() > 14 || lettersMatch.matches() == false) {
				System.out.print("Invalid city, please enter a valid city: ");
				city = scanner.nextLine();
			}
			else
				break;
		}
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		while(true) {
			lettersMatch = onlyLetters.matcher(state);
			if(state.length() > 2 || lettersMatch.matches() == false) {
				System.out.print("Invalid state, please enter a valid state: ");
				state = scanner.nextLine();
			}
			else
				break;
		}
		this.state = state;
	}
	
	public String getZIP() {
		return ZIP;
	}
	public void setZIP(String ZIP) {
		while(true) {
			numsMatch = onlyNums.matcher(ZIP);
			if(ZIP.length() != 5 || numsMatch.matches() == false) {
				System.out.print("Invalid ZIP, please enter a valid ZIP: ");
				ZIP = scanner.nextLine();
			}
			else
				break;
		}
		this.ZIP = ZIP;
	}

	public ArrayList<ServiceData> getServiceList() {
		return serviceList;
	}

	public void addService(ServiceData sData) {
		serviceList.add(sData);
	}
}

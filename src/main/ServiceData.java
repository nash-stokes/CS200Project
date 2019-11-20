package main;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** 
 * The ServiceData class stores contains information regarding individual services.
 * @author Erik Jones
*/
public class ServiceData {
	/** 
	 * The date the service took place
	*/
	private String serviceDate;
	/** 
	 * the current date and time
	*/
	private String serviceTime;
	/**
	 * the number of the provider involved
	 */
	private String providerNumber;
	/**
	 * the number of the member involved
	 */
	private String memberNumber;
	/** 
	 * the specific code of that service
	*/
	private String serviceCode;
	/**
	 * any additional comments (optional)
	 */
	private String comments;
	/** 
	 * the fee to be paid
	*/
	private double serviceFee;
	/** 
	 * the name of the member involved
	*/
	private String memberName;
	/**
	 * the name of the service
	 */
	private String serviceName;
	/**
	 * the name of the provider involved
	 */
	private String providerName;
	Scanner scanner = new Scanner(System.in);
	
	/** 
	 * Regex equation used to check for the format: MM-DD-YYYY
	*/
	Pattern dateFormat = Pattern.compile("\\d{2}-\\d{2}-\\d{4}");
	Matcher dateMatch;
	
	/**
	 * Regex equation used to check for the format: MM-DD-YYYY HH:MM:SS
	 */
	Pattern timeFormat = Pattern.compile("\\d{2}-\\d{2}-\\d{4}\\s\\d{2}:\\d{2}:\\d{2}");
	Matcher timeMatch;
	
	/** 
	 * Regex equation used to check if a String contains only numbers
	*/
	Pattern onlyNums = Pattern.compile("[0-9]+");
	Matcher numsMatch;
	
	/**
	 * Regex equation used to check if a String contains only letters
	 */
	Pattern onlyLetters = Pattern.compile("^[ A-Za-z]+$");
	Matcher lettersMatch;

	/**
	 * Default constructor with no paramters
	 */
	public ServiceData() {
		
	}

	/**
	 * Parameterized constructor
	 * @param serviceDate the date the service took place
	 * @param serviceTime the current date and time
	 * @param providerNumber the number of the provider involved
	 * @param memberNumber the number of the member involved
	 * @param serviceCode the specific code of that service
	 * @param comments any additional comments (optional)
	 * @param serviceFee the fee to be paid
	 * @param memberName the name of the member involved
	 */
	public ServiceData(String serviceDate, String serviceTime, String providerNumber, String memberNumber, String serviceCode, String comments, double serviceFee, String memberName, String serviceName, String providerName) {
		this.serviceDate = serviceDate;
		this.serviceTime = serviceTime;
		this.providerNumber = providerNumber;
		this.memberNumber = memberNumber;
		this.serviceCode = serviceCode;
		this.comments = comments;
		this.serviceFee = serviceFee;
		this.memberName = memberName;
		this.serviceName = serviceName;
		this.providerName = providerName;
	}

	/**
	 * getter for serviceDate
	 * @return serviceDate of the given ServiceData object
	 */
	public String getServiceDate() {
		return serviceDate;
	}
	/**
	 * setter for serviceDate
	 * will prompt user to re-enter if given value isn't in the correct format
	 * @param serviceDate the value serviceDate is to be set to
	 */
	public void setServiceDate(String serviceDate) {
		while(true) {
			dateMatch = dateFormat.matcher(serviceDate);
			if(dateMatch.matches() == false) {
				System.out.print("Invalid date, please enter in the format (MM-DD-YYYY): ");
				serviceDate = scanner.nextLine();
			}
			else
				break;
		}
		this.serviceDate = serviceDate;
	}
	/**
	 * getter for serviceTime
	 * @return serviceTime of the given ServiceData object
	 */
	public String getServiceTime() {
		return serviceTime;
	}
	/**
	 * setter for serviceTime
	 * will prompt user to re-enter if given value isn't in the correct format
	 * @param serviceTime the value serviceTime is to be set to
	 */
	public void setServiceTime(String serviceTime) {
		while(true) {
			timeMatch = timeFormat.matcher(serviceTime);
			if(timeMatch.matches() == false) {
				System.out.print("Invalid time, please enter in the format (MM-DD-YYYY HH:MM:SS): ");
				serviceTime = scanner.nextLine();
			}
			else
				break;
		}
		this.serviceTime = serviceTime;
	}
	/**
	 * getter for providerNumber
	 * @return providerNumber of the given ServiceData object
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
	
	/**
	 * getter for memberNumber
	 * @return memberNumber of the given ServiceData object
	 */
	public String getMemberNumber() {
		return memberNumber;
	}
	/**
	 * setter for memberNumber
	 * will prompt user to re-enter if given value isn't in the correct format
	 * @param memberNumber the value memberNumber is to be set to
	 */
	public void setMemberNumber(String memberNumber) {
		while(true) {
			numsMatch = onlyNums.matcher(memberNumber);
			if(memberNumber.length() != 9 || numsMatch.matches() == false) {
				System.out.print("Invalid member number, please enter a valid member number: ");
				memberNumber = scanner.nextLine();
			}
			else
				break;
		}
		this.memberNumber = memberNumber;
	}
	
	/**
	 * getter for serviceCode
	 * @return serviceCode of the given ServiceData object
	 */
	public String getServiceCode() {
		return serviceCode;
	}
	/**
	 * setter for serviceCode
	 * will prompt user to re-enter if given value isn't in the correct format
	 * @param serviceCode the value serviceCode is to be set to
	 */
	public void setServiceCode(String serviceCode) {
		while(true) {
			numsMatch = onlyNums.matcher(serviceCode);
			if(serviceCode.length() != 6 || numsMatch.matches() == false) {
				System.out.print("Invalid service code, please enter a valid service code: ");
				serviceCode = scanner.nextLine();
			}
			else
				break;
		}
		this.serviceCode = serviceCode;
	}
	/**
	 * getter for comments
	 * @return comments of the given ServiceData object
	 */
	public String getComments() {
		return comments;
	}
	/**
	 * setter for comments
	 * will prompt user to re-enter if given value isn't in the correct format
	 * @param comments the value comments is to be set to
	 */
	public void setComments(String comments) {
		while(comments.length() > 100) {
			System.out.print("Comments are limited to 100 characters, please re-enter your comment:");
			comments = scanner.nextLine();
		}
		this.comments = comments;
	}
	/**
	 * getter for serviceFee
	 * @return serviceFee of the given ServiceData object
	 */
	public double getServiceFee() {
		return serviceFee;
	}
	/**
	 * setter for serviceFee
	 * will prompt user to re-enter if given value isn't in the correct format
	 * @param serviceFee the value serviceFee is to be set to
	 */
	public void setServiceFee(double fee) {
		this.serviceFee = fee;
	}
	/**
	 * getter for memberName
	 * @return memberName of the given ServiceData object
	 */
	public String getMemberName() {
		return memberName;
	}
	/**
	 * setter for memberName
	 * will prompt user to re-enter if given value isn't in the correct format
	 * @param memberName the value memberName is to be set to
	 */
	public void setMemberName(String name) {
		while(true) {
			lettersMatch = onlyLetters.matcher(name);
			if(name.length() > 25 || lettersMatch.matches() == false) {
				System.out.print("Invalid name, please enter a valid name: ");
				name = scanner.nextLine();
			}
			else
				break;
		}
		this.memberName = name;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String name) {
		while(true) {
			lettersMatch = onlyLetters.matcher(name);
			if(name.length() > 25 || lettersMatch.matches() == false) {
				System.out.print("Invalid name, please enter a valid name: ");
				name = scanner.nextLine();
			}
			else
				break;
		}
		this.providerName = name;
	}
		

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		while(true) {
			lettersMatch = onlyLetters.matcher(serviceName);
			if(serviceName.length() > 20 || lettersMatch.matches() == false) {
				System.out.print("Invalid service name, please enter a valid service name: ");
				serviceName = scanner.nextLine();
			}
			else
				break;
		}
		this.serviceName = serviceName;
	}
	}
}

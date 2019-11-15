package main;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ServiceData {
	private String serviceDate;
	private String serviceTime;
	private String providerNumber;
	private String memberNumber;
	private String serviceCode;
	private String comments;
	
	Scanner scanner = new Scanner(System.in);
	
	//Check for date format:
	Pattern dateFormat = Pattern.compile("\\d{2}-\\d{2}-\\d{4}");
	Matcher dateMatch;
	
	//Check for date + time format
	Pattern timeFormat = Pattern.compile("\\d{2}-\\d{2}-\\d{4}\\s\\d{2}:\\d{2}:\\d{2}");
	Matcher timeMatch;
	
	//Check for provider/member number format
	Pattern onlyNums = Pattern.compile("[0-9]+");
	Matcher numsMatch;
	
	public String getServiceDate() {
		return serviceDate;
	}
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
	
	public String getServiceTime() {
		return serviceTime;
	}
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
	
	public String getMemberNumber() {
		return memberNumber;
	}
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
	
	public String getServiceCode() {
		return serviceCode;
	}
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
	
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		while(comments.length() > 100) {
			System.out.print("Comments are limited to 100 characters, please re-enter your comment:");
			comments = scanner.nextLine();
		}
		this.comments = comments;
	}
	
	
}

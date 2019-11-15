package cs200team4.project4.erik;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MemberData extends PersonData{
	private String memberNumber;
	private ServiceData memberServiceList[];
	
	Scanner scanner = new Scanner(System.in); //Scanner used to allow user to re-input fields 
	
	//Use these to validate a string has only numbers
	Pattern onlyNums = Pattern.compile("[0-9]+");
	Matcher numsMatch;
	
	public MemberData(String memberNumber, String name, String street, String city, String state, String ZIP) {
		super(name, street, city, state, ZIP);
		setMemberNumber(memberNumber);
	}
	
	public MemberData() {
		super();
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
}

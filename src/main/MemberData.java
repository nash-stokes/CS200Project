package main;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** 
 * The MemberData class stores personal information of ChocAN Members.
 * Inherits attributes and methods from the PersonData Class.
 * @author Erik Jones
*/
public class MemberData extends PersonData {
  /**
   * The unique number assigned to each member.
   */
  private String memberNumber;
	
  /**
   * Scanner that will be called if the user needs to re-input parameters.
   */
  Scanner scanner = new Scanner(System.in);
	
  /** 
   * Regex equation used to check if a String contains only numbers.
   */
  Pattern onlyNums = Pattern.compile("[0-9]+");
  Matcher numsMatch;
	
  /**
   * Parameterized constructor.
   * @param memberNumber unique number assigned to each member
   * @param name inherited from PersonData class
   * @param street inherited from PersonData class
   * @param city inherited from PersonData class
   * @param state inherited from PersonData class
   * @param ZIP inherited from PersonData class
   */
  public MemberData(String memberNumber, String name, String street, 
  		              String city, String state, String ZIP) {
    super(name, street, city, state, ZIP);
    setMemberNumber(memberNumber);
  }
	
  /**
   * Default contructor with no paramters.
   */
  public MemberData() {
    super();
  }

  /**
   * getter for memberNumber.
   * @return memberNumber of the given instance
   */
  public String getMemberNumber() {
    return memberNumber;
  }
  
  /**
   * setter for memberNumber.
   * will prompt user to re-enter if given value isn't in the correct format
   * @param memberNumber the value memberNumber is to be set to
   */
  public void setMemberNumber(String memberNumber) {
    while (true) {
      numsMatch = onlyNums.matcher(memberNumber);
      if (memberNumber.length() != 9 || numsMatch.matches() == false) {
        System.out.print("Invalid member number, please enter a valid member number: ");
        memberNumber = scanner.nextLine();
      } else {
        break;
      }
    }
    this.memberNumber = memberNumber;
  }
}

/**
 * This class stores and manages the MemberData objects which correspond to the members of the ChocAn network.
 *
 * @author Jonathan Pence
 * @version 1.0
 */

package main;

import java.util.ArrayList;

public class MemberController {

    /**
     * ArrayList which stores the MemberData objects that correspond to the members of the ChocAn network.
     */
    private static ArrayList<MemberData> memberList = new ArrayList<MemberData>();

    /**
     * Prompts the user for information on a member, which then is funneled into a MemberData constructor.
     * The new MemberData object is then stored into the arraylist.
     */
    public static void addMember() {
        IOController.output("Input: name, street, city, state, ZIP, and member number.");
        String name = IOController.getString();
        String street = IOController.getString();
        String city = IOController.getString();
        String state = IOController.getString();
        String ZIP = IOController.getString();
        String number = IOController.getString();
        while (validateCode(number)) {
            IOController.output("A member already exists with that number. Enter a different one.");
            number = IOController.getString();
        }
        MemberData x = new MemberData(name, street, city, state, ZIP, number);
        memberList.add(x);
        IOController.output("Member successfully added!");
    }

    /**
     * Prompts the user for a member number, and then deletes the MemberData object from the arraylist that corresponds with that number.
     */
    public static void deleteMember() {
        if (memberList.size() == 0) {
            IOController.output("No member exists to delete.");
            return;
        }

        IOController.output("Input member number of member you wish to remove.");
        String memberNumber = IOController.getString();
        for (int i = 0; i < memberList.size(); i++) {
            if (memberList.get(i).getMemberNumber().equals(memberNumber)) {
                memberList.remove(i);
                IOController.output("Member successfully removed!");
                return;
            }
        }
        IOController.output("No such member exists to remove.");
    }

    /**
     * Prompts the user to input a member number, after which the user is prompted to edit a certain field of the MemberData which corresponds to the given member number.
     */
    public static void updateMember() {
        String memberNumber = "0";
        int fieldChoice = 0;

        while (true) {
                IOController.output("Input member number of member you wish to update, or -1 to quit.");
                memberNumber = IOController.getString();
                if (memberNumber.equals("-1"))
                    return;

                for (int i = 0; i < memberList.size(); i++) {
                    if (memberList.get(i).getMemberNumber().equals(memberNumber)) {
                        while (fieldChoice != -1) {
                            IOController.output("-1 - Quit");
                            IOController.output(" 0 - Name");
                            IOController.output(" 1 - Street");
                            IOController.output(" 2 - City");
                            IOController.output(" 3 - State");
                            IOController.output(" 4 - ZIP");
                            IOController.output(" 5 - Toggle suspension");
                            fieldChoice = IOController.getInt();
                            switch (fieldChoice) {
                                case -1:
                                    break;
                                case 0:
                                    IOController.output("Input new name.");
                                    memberList.get(i).setName(IOController.getString());
                                    break;
                                case 1:
                                    IOController.output("Input new street.");
                                    memberList.get(i).setStreet(IOController.getString());
                                    break;
                                case 2:
                                    IOController.output("Input new city.");
                                    memberList.get(i).setCity(IOController.getString());
                                    break;
                                case 3:
                                    IOController.output("Input new state.");
                                    memberList.get(i).setState(IOController.getString());
                                    break;
                                case 4:
                                    IOController.output("Input new ZIP.");
                                    memberList.get(i).setZIP(IOController.getString());
                                    break;
                                case 5:
                                    IOController.output("Member suspension will be toggled from " + memberList.get(i).getStatus() + " to " + !memberList.get(i).getStatus() + ".");
                                	  memberList.get(i).toggleStatus();
                                	break;
                                default:
                                    IOController.output("Invalid selection.");
                                    break;
                            }
                            if (fieldChoice != -1)
                                IOController.output("Change successfully made!");
                        }
                        break;
                    }
                }
            }
    }

    /**
     * Prompts a the user for a member number, then checks to see if that member number corresponds to any MemberData which exists in the array list.
     *
     * @return true if there exists a MemberData object which corresponds to the given member number
     * @return false if such a MemberData does not exist
     */
    public static boolean validateMember() {
        if (memberList.size() == 0)
        {
            IOController.output("No member exists to validate!");
            return false;
        }

        IOController.output("Enter member number of member you wish to validate.");
        String memberNumber = IOController.getString();
        for (int i = 0; i < memberList.size(); i++) {
            if (memberNumber.equals(memberList.get(i).getMemberNumber())) {
                IOController.output("Member exists.");
                return true;
            }
        }

        IOController.output("No such member exists.");
        return false;
    }

    /**
     * Similar to the above verification function, however this method simply accepts a String as a parameter and returns whether or not it's a valid
     * member number without prompting the user or confirming/denying the validation through a print method.
     * 
     * @param memberCode a member number which may or may not be validated
     * @return true if memberCode is an existent member number
     * @return false if memberCode is a nonexistent member number
     */
    public static boolean validateCode(String memberCode) {
        for (int i = 0; i < memberList.size(); i++) {
            if (memberList.get(i).getMemberNumber().equals(memberCode))
                return true;
        }

        return false;
    }

    /**
     * Adds a service to the corresponding MemberData
     *
     * @param memberNumber given member number used to isolate the MemberData object that will have a service added to it
     * @param newService the service to be added
     */
    public static void addService(String memberNumber, ServiceData newService) {
        MemberData x = null;

        for (int i = 0; i < memberList.size(); i++) {
            if (memberList.get(i).getMemberNumber().equals(memberNumber)) {
                x = memberList.get(i);
                break;
            }
        }

        x.addService(newService);
    }

    /**
     * Get function for the ArrayList<MemberData> which corresponds to the members who are a part of the ChocAn network.
     *
     * @return the arraylist which stores the MemberData objects that correspond to the members
     */
    public static ArrayList<MemberData> getMemberList() {
        return memberList;
    }

    public static String fillName(String memberNumber) {
        for (int i = 0; i < memberList.size(); i++) {
            if (memberList.get(i).getMemberNumber().equals(memberNumber)) {
                return memberList.get(i).getName();
            }
        }

        return "NULL";
    }
}

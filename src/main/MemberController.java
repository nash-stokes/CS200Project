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
        MemberData x = new MemberData(IOController.getString(), IOController.getString(), IOController.getString(), IOController.getString(), IOController.getString(), IOController.getString());
        memberList.add(x);
        IOController.output("Member successfully added!");
    }

    /**
     * Prompts the user for a member number, and then deletes the MemberData object from the arraylist that corresponds with that number.
     */
    public static void deleteMember() {
        IOController.output("Input member number of member you wish to remove.");
        String memberNumber = IOController.getString();
        for (int i = 0; i < memberList.size(); i++) {
            if (memberList.get(i).getMemberNumber() == memberNumber) {
                memberList.remove(i);
                break;
            }
        }
        IOController.output("Member successfully removed!");
    }

    /**
     * Prompts the user to input a member number, after which the user is prompted to edit a certain field of the MemberData which corresponds to the given member number.
     */
    public static void updateMember() {
        String memberNumber = "0";
        int fieldChoice = 0;

        while (memberNumber != "-1") {
                IOController.output("Input member number of member you wish to update, or -1 to quit.");
                memberNumber = IOController.getString();
                for (int i = 0; i < memberList.size(); i++) {
                    if (memberList.get(i).getMemberNumber() == memberNumber) {
                        while (fieldChoice != -1) {
                            IOController.output("What would you like to modify? Enter ... or -1 to quit.");
                            fieldChoice = IOController.getInt();
                            switch (fieldChoice) {
                                case -1:
                                    break;
                                case 0:
                                    IOController.output("Input new name.");
                                    memberList.get(i).setName(IOController.getString());
                                    IOController.output("Name successfully changed!");
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
                                default:
                                    IOController.output("Invalid selection.");
                                    break;
                            }
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
            if (memberNumber == memberList.get(i).getMemberNumber())
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
            if (memberList.get(i).getMemberNumber() == memberNumber) {
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
}

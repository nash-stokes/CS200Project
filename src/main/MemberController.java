package main;

import java.util.ArrayList;

public class MemberController {

    private ArrayList<MemberData> memberList = new ArrayList<MemberData>();


    public void addMember() {
        IOController.output("Input: name, street, city, state, ZIP, and member number.");
        MemberData x = new MemberData(IOController.getString(), IOController.getString(), IOController.getString(), IOController.getString(), IOController.getString(), IOController.getString());
        memberList.add(x);
        IOController.output("Member successfully added!");
    }

    public void deleteMember() {
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

    // FINISH FUNCTION BELOW
    public void updateMember() {
        String memberNumber = "0";
        String fieldChoice = "null";

        while (memberNumber != "-1") {
                IOController.output("Input member number of member you wish to update, or -1 to quit.");
                memberNumber = IOController.getString();
                for (int i = 0; i < memberList.size(); i++) {
                    if (memberList.get(i).getMemberNumber() == memberNumber) {
                        while (fieldChoice != "-1") {
                            IOController.output("What would you like to modify? Enter ... or -1 to quit.");
                            fieldChoice = IOController.getString();
                            switch (fieldChoice) { // FIX LATER
                                default:
                                    break;
                            }
                        }
                        break;
                    }
                }
            }
    }

    public boolean validateMember() {
        String memberNumber;
        IOController.output("Enter member number of member you wish to validate.");
        memberNumber = IOController.getString();
        for (int i = 0; i < memberList.size(); i++) {
            if (memberNumber == memberList.get(i).getMemberNumber())
                return true;
        }

        return false;
    }
}

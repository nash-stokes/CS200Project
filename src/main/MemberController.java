package main;

import java.util.ArrayList;

public class MemberController {

    private static ArrayList<MemberData> memberList = new ArrayList<MemberData>();


    public static void addMember() {
        IOController.output("Input: name, street, city, state, ZIP, and member number.");
        MemberData x = new MemberData(IOController.getString(), IOController.getString(), IOController.getString(), IOController.getString(), IOController.getString(), IOController.getString());
        memberList.add(x);
        IOController.output("Member successfully added!");
    }

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
                                    memberList.get(i).setState(IOController.getString())
                                    break;
                                case 4:
                                    IOController.output("Input new ZIP.");
                                    memberList.get(i).setZIP(IOController.getString())
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

    public static boolean validateMember() {
        String memberNumber;
        IOController.output("Enter member number of member you wish to validate.");
        memberNumber = IOController.getString();
        for (int i = 0; i < memberList.size(); i++) {
            if (memberNumber == memberList.get(i).getMemberNumber())
                return true;
        }

        return false;
    }

    public static void addService(String memberNumber, ServiceData newService) {
        for (int i = 0; i < memberList.size(); i++) {
            if (memberList.get(i).getMemberNumber() == memberNumber) {
                MemberData x = memberList.get(i);
                break;
            }
        }

        x.addService(x);
    }

    public static ArrayList<MemberData> getMemberList() {
        return memberList;
    }
}

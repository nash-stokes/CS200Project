//package main;

import java.util.ArrayList;

public class ProviderController {

    private static ArrayList<ProviderData> providerList = new ArrayList<ProviderData>();

    public static void addProvider() {
        IOController.output("Input: name, street, city, state, ZIP, and provider number.");
        ProviderData x = new ProviderData(IOController.getString(), IOController.getString(), IOController.getString(), IOController.getString(), IOController.getString(), IOController.getString());
        ProviderList.add(x);
        ServiceController.incrementNumProviders();
        IOController.output("Provider successfully added!");
    }

    public static void deleteProvider() {
        IOController.output("Input provider number of provider you wish to remove.");
        String providerNumber = IOController.getString();
        for (int i = 0; i < providerList.size(); i++) {
            if (providerList.get(i).getProviderNumber() == providerNumber) {
                providerList.remove(i);
                break;
            }
        }
        ServiceController.decrementNumProviders();
        IOController.output("Provider successfully removed!");
    }

    public static void updateProvider() {
        String providerNumber = "0";
        int fieldChoice = 0;

        while (providerNumber != "-1") {
            IOController.output("Input provider number of provider you wish to update, or -1 to quit.");
            providerNumber = IOController.getString();
            for (int i = 0; i < providerList.size(); i++) {
                if (providerList.get(i).getProviderNumber() == providerNumber) {
                    while (fieldChoice != -1) {
                        IOController.output("What would you like to modify? Enter ... or -1 to quit.");
                        fieldChoice = IOController.getInt();
                        switch (fieldChoice) {
                            case -1:
                                break;
                            case 0:
                                IOController.output("Input new name.");
                                providerList.get(i).setName(IOController.getString());
                                IOController.output("Name successfully changed!");
                                break;
                            case 1:
                                IOController.output("Input new street.");
                                providerList.get(i).setStreet(IOController.getString());
                                break;
                            case 2:
                                IOController.output("Input new city.");
                                providerList.get(i).setCity(IOController.getString());
                                break;
                            case 3:
                                IOController.output("Input new state.");
                                providerList.get(i).setState(IOController.getString())
                                break;
                            case 4:
                                IOController.output("Input new ZIP.");
                                providerList.get(i).setZIP(IOController.getString())
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

    public static boolean validateProvider() {
        String providerNumber;
        IOController.output("Enter provider number of provider you wish to validate.");
        providerNumber = IOController.getString();
        for (int i = 0; i < providerList.size(); i++) {
            if (providerNumber == providerList.get(i).getProviderNumber()) {
                IOController.output("Successfully validated.");
                return true;
            }
        }

        IOController.output("Failed to validate.");
        return false;
    }

    public static void addService(String providerNumber, ServiceData newService) {
        for (int i = 0; i < providerList.size(); i++) {
            if (providerList.get(i).getProviderNumber() == providerNumber) {
                ProviderData x = providerList.get(i);
                break;
            }
        }

        x.addService(x);
    }
}
/**
 * This class stores and manages the providers which are part of the ChocAn network.
 *
 * @author Jonathan Pence
 * @version 1.0
 */
package main;

import java.util.ArrayList;

public class ProviderController {

    /**
     * ArrayList of ProviderData which stores the providers who are a part of the ChocAn network.
     */
    private static ArrayList<ProviderData> providerList = new ArrayList<ProviderData>();

    /**
     * Adds a provider by prompting the user for information, which is then funneled into a parameterized ProviderData constructor.
     * Then, stores the new ProviderData into the providerList arraylist.
     */
    public static void addProvider() {
        IOController.output("Input: name, street, city, state, ZIP, and provider number.");
        ProviderData x = new ProviderData(IOController.getString(), IOController.getString(), IOController.getString(), IOController.getString(), IOController.getString(), IOController.getString());
        providerList.add(x);
        IOController.output("Provider successfully added!");
    }

    /**
     * Deletes a provider given the number of a provider which is prompted for within the method.
     */
    public static void deleteProvider() {
        IOController.output("Input provider number of provider you wish to remove.");
        String providerNumber = IOController.getString();
        for (int i = 0; i < providerList.size(); i++) {
            if (providerList.get(i).getProviderNumber() == providerNumber) {
                providerList.remove(i);
                break;
            }
        }
        IOController.output("Provider successfully removed!");
    }

    /**
     * Prompts the user to input the number of the provider they wish to update, then the field they wish to update.
     */
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
                                providerList.get(i).setState(IOController.getString());
                                break;
                            case 4:
                                IOController.output("Input new ZIP.");
                                providerList.get(i).setZIP(IOController.getString());
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
     * Validates a provider by checking a given provider number against all the existing providers which are stored within the system.
     *
     * @return true if a match exists
     * @return false if a match isn't found
     */
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

    /**
     * Adds a service to a specified provider, given a valid provider number and service.
     *
     * @param providerNumber The provider number which specifies which ProviderData object to store the ServiceData within.
     * @param newService The ServiceData which will be stored within a ProviderData object.
     */
    public static void addService(String providerNumber, ServiceData newService) {
        ProviderData x  = null;

        for (int i = 0; i < providerList.size(); i++) {
            if (providerList.get(i).getProviderNumber() == providerNumber) {
                x = providerList.get(i);
                break;
            }
        }

        x.addService(newService);
    }

    /**
     * Gets the list of all providers who are a part of the ChocAn network.
     *
     * @return ArrayList<ProviderData> which is populated with ProviderData objects which correspond to the providers who are a part of the ChocAn network.
     */
    public static ArrayList<ProviderData> getProviderList() {
        return providerList;
    }
}
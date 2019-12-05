/**
 * This class stores and manages the providers which are part of the ChocAn network.
 *
 * @author Jonathan Pence
 * @version 1.0
 */
package main;

import java.util.ArrayList;

public class ProviderController {

  /** ArrayList of ProviderData which stores the providers who are a part of the ChocAn network. */
  private static ArrayList<ProviderData> providerList = new ArrayList<ProviderData>();

  /**
   * Adds a provider by prompting the user for information, which is then funneled into a
   * parameterized ProviderData constructor. Then, stores the new ProviderData into the providerList
   * arraylist.
   */
  public static void addProvider() {
    IOController.output("Input: name, street, city, state, ZIP, and provider number.");
    String name = IOController.getString();
    String street = IOController.getString();
    String city = IOController.getString();
    String state = IOController.getString();
    String ZIP = IOController.getString();
    String number = IOController.getString();
    while (validateCode(number)) {
      IOController.output("A provider already exists with that number. Enter a different one.");
      number = IOController.getString();
    }
    ProviderData x = new ProviderData(name, street, city, state, ZIP, number);
    providerList.add(x);
    IOController.output("Provider successfully added!");
  }

  /** Deletes a provider given the number of a provider which is prompted for within the method. */
  public static void deleteProvider() {
    if (providerList.size() == 0) {
      IOController.output("No provider exists to delete.");
      return;
    }

    IOController.output("Input provider number of provider you wish to remove.");
    String providerNumber = IOController.getString();
    for (int i = 0; i < providerList.size(); i++) {
      if (providerList.get(i).getProviderNumber().equals(providerNumber)) {
        providerList.remove(i);
        IOController.output("Provider successfully removed!");
        return;
      }
    }
    IOController.output("No such provider exists to remove.");
  }

  /**
   * Prompts the user to input the number of the provider they wish to update, then the field they
   * wish to update.
   */
  public static void updateProvider() {
    String providerNumber = "0";
    int fieldChoice = 0;

    while (true) {
      IOController.output("Input provider number of provider you wish to update, or -1 to quit.");
      providerNumber = IOController.getString();
      if (providerNumber.equals("-1")) return;

      for (int i = 0; i < providerList.size(); i++) {
        if (providerList.get(i).getProviderNumber().equals(providerNumber)) {
          while (fieldChoice != -1) {
            IOController.output("-1 - Quit");
            IOController.output(" 0 - Name");
            IOController.output(" 1 - Street");
            IOController.output(" 2 - City");
            IOController.output(" 3 - State");
            IOController.output(" 4 - ZIP");
            IOController.output(" 5 - Toggle status");
            fieldChoice = IOController.getInt();
            switch (fieldChoice) {
              case -1:
                break;
              case 0:
                IOController.output("Input new name.");
                providerList.get(i).setName(IOController.getString());
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
              case 5:
                IOController.output(
                    "Provider status will be toggled from "
                        + providerList.get(i).getStatus()
                        + " to "
                        + !providerList.get(i).getStatus()
                        + ".");
                providerList.get(i).toggleStatus();
                break;
              default:
                IOController.output("Invalid selection.");
                break;
            }
            if (fieldChoice != -1) IOController.output("Change successfully made!");
          }
          break;
        }
      }
    }
  }

  /**
   * Validates a provider by checking a given provider number against all the existing providers
   * which are stored within the system.
   *
   * @return true if a match exists
   * @return false if a match isn't found
   */
  public static boolean validateProvider() {
    if (providerList.size() == 0) {
      IOController.output("No provider exists to validate!");
      return false;
    }

    String providerNumber;
    IOController.output("Enter provider number of provider you wish to validate.");
    providerNumber = IOController.getString();
    for (int i = 0; i < providerList.size(); i++) {
      if (providerNumber.equals(providerList.get(i).getProviderNumber())) {
        IOController.output("Provider exists.");
        return true;
      }
    }

    IOController.output("No such provider exists.");
    return false;
  }

  /**
   * Similar to the above verification function, however this method simply accepts a String as a
   * parameter and returns whether or not it's a valid provider number without prompting the user or
   * confirming/denying the validation through a print method.
   *
   * @param providerNumber a valid provider number which may or may not be validated
   * @return true if providerNumber is an existent provider number
   * @return false if providerNumber is a nonexistent provider number
   */
  public static boolean validateCode(String providerNumber) {
    for (int i = 0; i < providerList.size(); i++) {
      if (providerList.get(i).getProviderNumber().equals(providerNumber)) return true;
    }

    return false;
  }

  /**
   * Adds a service to a specified provider, given a valid provider number and service.
   *
   * @param providerNumber The provider number which specifies which ProviderData object to store
   *     the ServiceData within.
   * @param newService The ServiceData which will be stored within a ProviderData object.
   */
  public static void addService(String providerNumber, ServiceData newService) {
    ProviderData x = null;

    for (int i = 0; i < providerList.size(); i++) {
      if (providerList.get(i).getProviderNumber().equals(providerNumber)) {
        x = providerList.get(i);
        break;
      }
    }

    x.addService(newService);
  }

  /**
   * Gets the list of all providers who are a part of the ChocAn network.
   *
   * @return ArrayList<ProviderData> which is populated with ProviderData objects which correspond
   *     to the providers who are a part of the ChocAn network.
   */
  public static ArrayList<ProviderData> getProviderList() {
    return providerList;
  }

  public static String fillName(String providerNumber) {
    for (int i = 0; i < providerList.size(); i++) {
      if (providerList.get(i).getProviderNumber().equals(providerNumber)) {
        return providerList.get(i).getName();
      }
    }

    return "NULL";
  }
}

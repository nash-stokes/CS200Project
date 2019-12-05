package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This program creates provider directory data for the provider to see. Once called, it will create
 * a text file and save it onto the terminal for it to be sent as email.
 *
 * @author Sanghyun Jeon
 */
public class ProviderDirectoryData {
  /** Array of service code. */
  private static ArrayList<String> serviceCodes = new ArrayList<String>();

  /** Array of service names. */
  private static ArrayList<String> serviceNames = new ArrayList<String>();

  /** Array of service fees. */
  private static ArrayList<String> serviceFees = new ArrayList<String>();

  /** A variable for the code value. */
  private static String codes;

  /** A variable for the name of the service. */
  private static String names;

  /** A variable for the service fee. */
  private static double fees;

  /**
   * Reads the file of Provider Directory and collects all the necessary information into an array.
   *
   * @throws IOException Throws exception when the file is not found, cannot be written, or read.
   */
  public static void readFile() {
    try {
      File file = new File("ProviderDirectory.txt");
      FileReader fr = new FileReader(file);
      BufferedReader br = new BufferedReader(fr);
      String line;
      line = br.readLine();
      for (String word : line.split(" ")) {
        serviceNames.add(word);
      }
      line = br.readLine();
      for (String word : line.split(" ")) {
        serviceCodes.add(word);
      }
      line = br.readLine();
      for (String number : line.split(" ")) {
        serviceFees.add(number);
      }
      br.close();
      fr.close();
    } catch (IOException e) {
      IOController.output("ProviderDirectory.txt not found!");
    }
  }

  /** Returns the number of services. */
  public static int getSize() {
    return serviceCodes.size();
  }

  /**
   * Locates the specific code and returns that value.
   *
   * @param i The index at which the specific service can be found.
   * @return Returns the specific service code of a specific service.
   */
  public static String getServiceCodes(int i) {
    codes = serviceCodes.get(i);
    return codes;
  }

  /**
   * Locates the specific name and returns that name.
   *
   * @param i The index at which the specific service can be found.
   * @return Returns the specific service name of a specific service.
   */
  public static String getServiceNames(int i) {
    names = serviceNames.get(i);
    return names;
  }

  /**
   * Locates the specific fee amount and returns that value.
   *
   * @param i The index at which the specific service can be found.
   * @return Returns the specific service fee of a specific service.
   */
  public static double getServiceFees(int i) {
    String f = serviceFees.get(i);
    fees = Double.parseDouble(f);
    return fees;
  }

  /**
   * This function returns the name of a service given a service code.
   *
   * @param serviceCode a service code
   * @return String corresponding to the name of the service with the inputted service code
   */
  public static String fillName(String serviceCode) {
    for (int i = 0; i < serviceCodes.size(); i++) {
      if (serviceCodes.get(i).equals(serviceCode)) {
        return serviceNames.get(i);
      }
    }

    return "NULL";
  }

  /**
   * This function returns the fe of a service given a service code.
   *
   * @param serviceCode a service code
   * @return double corresponding to the fee of the service with the inputted service code
   */
  public static double fillFee(String serviceCode) {
    for (int i = 0; i < serviceCodes.size(); i++) {
      if (serviceCodes.get(i).equals(serviceCode)) {
        return Double.parseDouble(serviceFees.get(i));
      }
    }

    return 0.0;
  }

  /**
   * This function determines whether or not a service with the inputted service code exists.
   *
   * @param serviceCode the service code that will be checked for existence
   * @return boolean true if service code exists, false if it does not exist
   */
  public static boolean exists(String serviceCode) {
    for (int i = 0; i < serviceCodes.size(); i++) {
      if (serviceCodes.get(i).equals(serviceCode)) return true;
    }

    return false;
  }

  /**
   * Validates that the inputted service code was the service the provider meant to enter.
   *
   * @param serviceCode the service code whose name will be displayed for verification
   * @return boolean true if the provider accepts the service name, false if the provider rejects
   *     the service name
   */
  public static boolean validate(String serviceCode) {
    IOController.output("Is this the correct service which was performed? Enter \"y\" or \"n\":");
    IOController.output(fillName(serviceCode));

    while (true) {
      String answer = IOController.getString();
      if (answer.equals("y")) return true;
      else if (answer.equals("n")) return false;
      else IOController.output("Invalid answer. Enter \"y\" or \"n\".");
    }
  }
}

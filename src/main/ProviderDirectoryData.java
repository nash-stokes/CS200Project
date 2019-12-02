package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/** This program creates provider directory data for the provider to see. 
 * Once called, it will create a text file and save it onto the terminal for it to be sent as email.
 * @author Sanghyun Jeon
 */

public class ProviderDirectoryData {
  /** Array of service code. 
  */
  private static ArrayList<String> serviceCodes = new ArrayList<String>();

  /** Array of service names.
  */
  private static ArrayList<String> serviceNames = new ArrayList<String>();

  /** Array of service fees.
  */
  private static ArrayList<String> serviceFees = new ArrayList<String>();

  /** A variable for the code value.
  */
  private static String codes;

  /** A variable for the name of the service.
  */
  private static String names;

  /** A variable for the service fee.
  */
  private static double fees;

  /** Reads the file of Provider Directory and collects all the necessary information into an array.
  * @throws IOException Throws exception when the file is not found, cannot be written, or read.
  */
  public void readFile() throws IOException {
    File file =  new File("ProviderDirectory.txt");
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
  }

  /** Returns the number of services.
  */
  public static int getSize() {
    return serviceCodes.size();
  }

  /**
  * Locates the specific code and returns that value.
  * @param i The index at which the specific service can be found.
  * @return Returns the specific service code of a specific service.
  */
  public static String getServiceCodes(int i) {
    codes = serviceCodes.get(i);
    return codes;
  }

  /**
  * Locates the specific name and returns that name.
  * @param i The index at which the specific service can be found.
  * @return Returns the specific service name of a specific service.
  */
  public static String getServiceNames(int i) {
    names = serviceNames.get(i);
    return names;
  }

  /**
  * Locates the specific fee amount and returns that value.
  * @param i The index at which the specific service can be found.
  * @return Returns the specific service fee of a specific service.
  */
  public static double getServiceFees(int i) {
    String f = serviceFees.get(i);
    fees = Double.parseDouble(f);
    return fees;
  }
}

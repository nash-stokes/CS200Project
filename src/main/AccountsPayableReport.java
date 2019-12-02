package main;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**Accounts Payable Report is a report for managers to see which accounts are payable. 
 * Once called, it will create a text file and save it onto the terminal for it to be sent as email.
 * @author Sanghyun Jeon     CWID: 11868089
 */

public class AccountsPayableReport {
  /** numOfConsults is the number of service that each of the providers provided for members.
  */
  private static int numOfConsults;

  /** The variable feeTotal is the total amount of fee that each of the provider accumulated.
  */
  private static double feeTotal;

  /** The variable finalConsults is the overall number of services that all 
   * the providers has provided for the members.
  */
  private static int finalConsults = 0;
  
  /** finalFeeTotal is the overall cost of fee that all the providers had provided for the members.
  */
  private static double finalFeeTotal = 0;

  /** The function, printAccountsPayableReport when called, will gather data from the necessary 
   * objects and write the information in the text file.
  * It will create a file, open it, and write in the necessary information in the correct format .
  * @throws IOException Throws exception when the file is not found, cannot be written, or read.
  */
  public static void printAccountsPayableReport() throws IOException {
    FileWriter file = new FileWriter("AccountsPayableReport.txt");
    PrintWriter writing = new PrintWriter(file);
    writing.println("Providers to be paid | Number of Consultations | Total Fee: ");
    for (int x = 0; x < ProviderController.getProviderList().size(); x++) {
      numOfConsults =  ServiceController.getServiceList().size();
      feeTotal = ServiceController.getTotalFee(); 
      writing.println(ProviderController.getProviderList().get(x).getName() 
          + " | " + numOfConsults + " | " + feeTotal);
      finalConsults = finalConsults + numOfConsults;
      finalFeeTotal = finalFeeTotal + feeTotal;
    }
    writing.println();
    writing.println("Total number of providers: " + ProviderController.getProviderList().size());
    writing.println("Total number of consultations: " + finalConsults);
    writing.println("Total Fee: " + finalFeeTotal);
    writing.close();
  }
}

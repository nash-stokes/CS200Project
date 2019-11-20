package main;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Sanghyun Jeon
 * 
 * This program creates accounts payable report for the manager to see. Oce called, it will create a textfile and save it onto the terminal for it to e sent as email.
 */

public class AccountsPayableReport {
	/**
	 * The variable numOfConsults is the number of service that each of the providers provided for members
	 */
	private static int numOfConsults;

	/**
	 * The variable feeTotal is the total amount of fee that each of the provider cumulated over the services that each of them has provided
	 */
	private static double feeTotal;

	/**
	 * The variable finalConsults is the overall number of services that all the providers has provided for the members.
	 */
	private static int finalConsults = 0;

	/**
	 * The variable finalFeeTotal is the overall cost of fee that all the providers had provided for the members.
	 */
	private static double finalFeeTotal = 0;
	
	/**
	 * The function, printAccountsPayableReport when called, will gather data from the necessary objects and write the information in the text file.
	 * It will create a file, open it, and write in the necessary information in the correct format demanded by ChocAn.
	 * @throws IOException
	 */
	public static void printAccountsPayableReport() throws IOException {
		FileWriter file = new FileWriter("AccountsPayableReport.txt");
		PrintWriter writing = new PrintWriter(file);
		writing.println("Providers to be paid | Number of Consultations | Total Fee: ");
		for(int x = 0; x < ProviderController.getProviderList().size(); x++) {
			numOfConsults =  ServiceController.getServiceList().size();
			feeTotal = ServiceController.getTotalFee(); 
			writing.println(ProviderController.getProviderList().get(x).getName() + " | " + numOfConsults + " | " + feeTotal);
			finalConsults = finalConsults + numOfConsults;
			finalFeeTotal = finalFeeTotal + feeTotal;
		}
		writing.println();
		writing.println("Total number of providers: " + ProviderController.getProviderList().size());
		writing.println("Total number of consultations: " + finalConsults);
		writing.println("Total Fee: " + finalFeeTotal);
		writing.close();
	}
};

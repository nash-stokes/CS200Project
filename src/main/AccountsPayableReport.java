package main;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class AccountsPayableReport {
	private static int numOfConsults;
	private static double overallFeeTotal;
	private static int finalConsults = 0;
	private static double finalFeeTotal = 0;
	
	public static void printAccountsPayableReport() throws IOException {
		FileWriter file = new FileWriter("AccountsPayableReport.txt");
		PrintWriter writing = new PrintWriter(file);
		writing.println("Providers to be paid | Number of Consultations | Total Fee: ");
		for(int x = 0; x < ProviderController.getProviderList().size(); x++) {
			numOfConsults =  ServiceController.getServiceList().size();
			overallFeeTotal = ServiceController.getTotalFee(); //figure out later
			writing.println(ProviderController.getProviderList().get(x).getName() + " | " + numOfConsults + " | " + overallFeeTotal);
			finalConsults = finalConsults + numOfConsults;
			finalFeeTotal = finalFeeTotal + overallFeeTotal;
		}
		writing.println();
		writing.println("Total number of providers: " + ProviderController.getProviderList().size());
		writing.println("Total number of consultations: " + finalConsults);
		writing.println("Total Fee: " + finalFeeTotal);
		writing.close();
	}
};

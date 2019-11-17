package main;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class AccountsPayableReport {
	private static ArrayList<ProviderData> providerList = new ArrayList<ProviderData>();
	private static ArrayList<ServiceData> serviceList = new ArrayList<ServiceData>();
	private static int numOfProviders = providerList.size();
	private static int numOfConsults;
	private static double overallFeeTotal;
	private static int finalConsults = 0;
	private static double finalFeeTotal = 0;
	
	public static void printAccountsPayableReport() throws IOException {
		FileWriter file = new FileWriter("AccountsPayableReport.txt");
		PrintWriter writing = new PrintWriter(file);
		writing.println("Providers to be paid | Number of Consultations | Total Fee: ");
		for(int x = 0; x < providerList.size(); x++) {
			numOfConsults =  serviceList.getCountServices(x); //figure out later
			overallFeeTotal = serviceList.getTotalFee(x); //figure out later
			writing.println(providerList.get(x).getName() + " | " + numOfConsults + " | " + overallFeeTotal);
			finalConsults = finalConsults + numOfConsults;
			finalFeeTotal = finalFeeTotal + overallFeeTotal;
		}
		writing.println();
		writing.println("Total number of providers: " + numOfProviders);
		writing.println("Total number of consultations: " + finalConsults);
		writing.println("Total Fee: " + finalFeeTotal);
		writing.close();
	}
};

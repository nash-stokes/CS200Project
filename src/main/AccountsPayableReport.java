package main;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class AccountsPayableReport {
	private ArrayList<ProviderData> providerList = new ArrayList<ProviderData>();
	private ArrayList<ServiceData> service = new ArrayList<ServiceData>();
	private int numOfProviders = service.getNumProviders;
	private int numOfConsults = service.getCountServices;
	private float overallFeeTotal = service.getTotalFee();
	private int finalConsults = 0;
	private float finalFeeTotal = 0;
	
	public void printAccountsPayableReport() {
		FileWriter file = new FileWriter("AccountsPayableReport.txt");
	    PrintWriter writing = new PrintWriter(file);
		writing.println("Providers to be paid | Number of Consultations | Total Fee: ");
		for(int x = 0; x < providerList.size(); x++) {
			writing.println(providerList.getName() + " | " + numOfConsults + " | " + overallFeeTotal);
			finalConsults = finalConsults + numOfConsults;
			finalFeeTotal = finalFeeTotal + overallFeeTotal;
		}
		writing.println();
		writing.println("Total number of providers: " + numOfProviders);
		writing.println("Total number of consultations: " + finalConsults);
		writing.println("Total Fee: " + finalFeeTotal);
	}
}

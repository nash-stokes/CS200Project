package main;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class AccountsPayableReport {
	private ArrayList<ProviderData> providerList = new ArrayList<ProviderData>();
	private ArrayList<ServiceData> service = new ArrayList<ServiceData>();
	private int numOfProviders = providerList.size();
	private int numOfConsults;
	private double overallFeeTotal;
	private int finalConsults = 0;
	private double finalFeeTotal = 0;
	
	public void printAccountsPayableReport() throws IOException {
		FileWriter file = new FileWriter("AccountsPayableReport.txt");
		PrintWriter writing = new PrintWriter(file);
		writing.println("Providers to be paid | Number of Consultations | Total Fee: ");
		for(int x = 0; x < providerList.size(); x++) {
			numOfConsults =  service.getCountServices(x); //figure out later
			overallFeeTotal = service.getTotalFee(x); //figure out later
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

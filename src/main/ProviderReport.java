package main;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * @author Sanghyun Jeon
 * 
 * This program creates accounts payable report for the manager to see. Oce called, it will create a textfile and save it onto the terminal for it to e sent as email.
 */

public class ProviderReport {
  private String providerName;
  private String providerNumber;
  private String providerAddress;
  private String providerCity;
  private String providerState;
  private String providerZIP;
  private ArrayList<ServiceData> service = new ArrayList<ServiceData>();
  private int numOfConsults = service.size();
  private float totalFee = 0;

  public ProviderReport(ProviderData obj) {
    providerName = obj.getName();
    providerNumber = obj.getProviderNumber();
    providerAddress = obj.getStreet();
    providerCity = obj.getCity();
    providerZIP = obj.getZIP();
    service = obj.getServiceList();
    numOfConsults = service.size();
    for (int i = 0; i < service.size(); i++) {
        totalFee += service.get(i).getServiceFee();
    }
  }

  public void printProviderReport() throws IOException {
    FileWriter file = new FileWriter(providerName+".txt");
    PrintWriter writing = new PrintWriter(file);
    writing.print("Provider name: " + providerName);
    writing.println("Provider number: " + providerNumber);
    writing.println("Provider street address: " + providerAddress);
    writing.println("Provider city: " + providerCity);
    writing.println("Provider state: " + providerState);
    writing.println("Provider ZIP code: " + providerZIP);
    printServiceData(writing);
    writing.println("Total number of consultations with members" + numOfConsults);
    writing.println("Total fee for week" + totalFee);
    writing.close();
	}
	
	public void printServiceData(PrintWriter write) throws IOException{
		for(int x = 0; x < service.size(); x++){
		  write.println("Date of service: " + service.get(x).getServiceDate());
		  write.println("Date and time data were received by the computer: " + service.get(x).getServiceTime());
		  write.println("Member name: " + service.get(x).getMemberName()); // ERROR CURRENTLY BECAUSE ERIK'S DUMBASS FORGOT TO INCLUDE A MEMBERNAME ATTRIBUTE IN SERVICEDATA
            write.println("Member number: " + service.get(x).getMemberNumber());
		  write.println("Service code: " + service.get(x).getServiceCode());
		  write.println("Fee to be paid: "+ service.get(x).getServiceFee());
		  write.println();
		}
	}
}
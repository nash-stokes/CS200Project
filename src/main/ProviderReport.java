package main;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

// connect service controller to provider report for service data

public class ProviderReport {
  private String providerName;
  private String providerNumber;
  private String providerAddress;
  private String providerCity;
  private String providerState;
  private String providerZIP;
  private ArrayList<ServiceData> service = new ArrayList<ServiceData>();
  private int numOfConsults = service.getCountServices()
  private float totalFee = services.getTotalFee();
  
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
		  write.println("Date of service: " + service.getServiceDate());
		  write.println("Date and time data were received by the computer: " + service.getServiceTime());
		  write.println("Member name: " + service.MemberData.getName());
		  write.println("Member number: " + service.getMemberNumber());
		  write.println("Service code: " + service.getServiceCode());
		  write.println("Fee to be paid: "+ service.getServiceFee());
		  write.println();
		}
	}
}

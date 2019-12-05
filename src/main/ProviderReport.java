package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * This program creates provider report for the manager to see. Once called, it will create a
 * textfile and save it onto the terminal for it to be sent as email.
 *
 * @author Sanghyun Jeon
 */
public class ProviderReport {
  /** The variable providerName is for reserving space for provider name. */
  private String providerName;

  /** The variable providerNumber is reserving space for provider number. */
  private String providerNumber;

  /** The variable providerAddress is reserving space for provider's street address. */
  private String providerAddress;

  /** The variable providerCity is reserving space for provider's city. */
  private String providerCity;

  /** The variable providerState is reserving space for provider's state. */
  private String providerState;

  /** The variable providerZIP is reserving space for provider's zipcode. */
  private String providerZip;

  /** The variable service creates an ArrayList for the service data. */
  private ArrayList<ServiceData> service;

  /** The variable numOfConsults in the number of services that all the providers has provided. */
  private int numOfConsults;

  /**
   * The variable totalFee is initialized to accumulate through the service fees of the providers.
   */
  private float totalFee = 0;

  /**
   * ProviderReport is created to assign variables to provider's information into the report.
   *
   * @param obj Provider report function obtains to get a specific individual provider.
   */
  public ProviderReport(ProviderData obj) {
    providerName = obj.getName();
    providerNumber = obj.getProviderNumber();
    providerAddress = obj.getStreet();
    providerCity = obj.getCity();
    providerState = obj.getState();
    providerZip = obj.getZIP();
    service = obj.getServiceList();
    numOfConsults = service.size();
    for (int i = 0; i < service.size(); i++) {
      totalFee += service.get(i).getServiceFee();
    }
  }

  /**
   * printProviderReport collects information and writes a file under that provider name. Its format
   * imitates ChocAn format.
   *
   * @throws IOException Throws exception when the file is not found, cannot be written, or read.
   */
  public void printProviderReport() throws IOException {
    File providerReports = new File("providerReports");
    providerReports.mkdir();
    FileWriter file = new FileWriter("providerReports/" + providerNumber + ".txt");
    PrintWriter writing = new PrintWriter(file);
    writing.println("Provider name: " + providerName);
    writing.println("Provider number: " + providerNumber);
    writing.println("Provider street address: " + providerAddress);
    writing.println("Provider city: " + providerCity);
    writing.println("Provider state: " + providerState);
    writing.println("Provider ZIP code: " + providerZip);
    writing.println();
    printServiceData(writing);
    writing.println("Total number of consultations with members: " + numOfConsults);
    writing.println("Total fee for week: $" + totalFee);
    writing.close();
  }

  /**
   * The function printServiceData prints all the services under the provider's name.
   *
   * @param write Takes in a write parameter which is a file writing tool to write all the services.
   * @throws IOException IOException Throws exception when the file is not found, written, or read.
   */
  public void printServiceData(PrintWriter write) throws IOException {
    for (int x = 0; x < service.size(); x++) {
      write.println("Date of service: " + service.get(x).getServiceDate());
      write.println(
          "Date and time data were received by the computer: " + service.get(x).getServiceTime());
      write.println("Member name: " + service.get(x).getMemberName());
      write.println("Member number: " + service.get(x).getMemberNumber());
      write.println("Service code: " + service.get(x).getServiceCode());
      write.println("Fee to be paid: $" + service.get(x).getServiceFee());
      write.println();
    }
  }
}

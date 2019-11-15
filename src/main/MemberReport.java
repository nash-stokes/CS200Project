//Nash
package main;

import java.io.*;

public class MemberReport{
    String memberName;
    String memberNumber;
    String memberAddress;
    String memberCity;
    String memberState;
    String memberZIP;
    String serviceInfo;

    FileWriter out = null;

    public void printMemberReport(){
        memberName = getMemberName();
        memberNumber = getMemberNumber();
        memberAddress = getMemberAddress();
        memberCity = getMemberCity();
        memberState = getMemberState();
        memberZip = getMemberZIP();
        serviceInfo = getServiceInfo();

        out = new FileWriter("MemberReport.txt");

        System.out.println("Member Name: " + memberName);
        System.out.println("Member Number: " + memberNumber);
        System.out.println("Member Address: " + memberAddress);
        System.out.println("Member City: " + memberCity);
        System.out.println("Member State: " + memberState);
        System.out.println("Member ZIP: " + memberZIP);
        System.out.println("Service Information: " + serviceInfo);
        
    }

    // public void printProviderReport() throws IOException {
    //     FileWriter file = new FileWriter(providerName+".txt");
    //     PrintWriter writing = new PrintWriter(file);
    //     writing.print("Provider name: " + providerName);
    //     writing.println("Provider number: " + providerNumber);
    //     writing.println("Provider street address: " + providerAddress);
    //     writing.println("Provider city: " + providerCity);
    //     writing.println("Provider state: " + providerState);
    //     writing.println("Provider ZIP code: " + providerZIP);
    //     printServiceData(writing);
    //     writing.println("Total number of consultations with members" + numOfConsults);
    //     writing.println("Total fee for week" + totalFee);
    //     writing.close();
    // }

    // public void printServiceData(PrintWriter write) throws IOException{
	// 	for(int x = 0; x < service.size(); x++){
	// 	  write.println("Date of service: " + service.getServiceDate());
	// 	  write.println("Date and time data were received by the computer: " + service.getServiceTime());
	// 	  write.println("Member name: " + service.MemberData.getName());
	// 	  write.println("Member number: " + service.getMemberNumber());
	// 	  write.println("Service code: " + service.getServiceCode());
	// 	  write.println("Fee to be paid: "+ service.getServiceFee());
	// 	  write.println();
	// 	}
	// }
}
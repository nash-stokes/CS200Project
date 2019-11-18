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

    public void printMemberReport(){
        memberName = getMemberName();
        memberNumber = getMemberNumber();
        memberAddress = getMemberAddress();
        memberCity = getMemberCity();
        memberState = getMemberState();
        memberZip = getMemberZIP();
        serviceInfo = getServiceInfo();

        FileWriter file = new FileWriter(memberName+".txt");
        PrintWriter writing = new PrintWriter(file);

        writing.println("Member name: " + memberName);
        writing.println("Member number: " + memberNumber);
        writing.println("Member street address: " + memberAddress);
        writing.println("Member city: " + memberCity);
        writing.println("Member state: " + memberState);
        writing.println("Member ZIP: " + memberZIP);
        System.out.println("Service Information: " + serviceInfo);
        printServiceData(writing);
        writing.close();
        
    }

    // public void printMemberReport() throws IOException {
    //     FileWriter file = new FileWriter(MemberName+".txt");
    //     PrintWriter writing = new PrintWriter(file);
    //     writing.print("Member name: " + MemberName);
    //     writing.println("Member number: " + MemberNumber);
    //     writing.println("Member street address: " + MemberAddress);
    //     writing.println("Member city: " + MemberCity);
    //     writing.println("Member state: " + MemberState);
    //     writing.println("Member ZIP code: " + MemberZIP);
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
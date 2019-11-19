//Nash
package main;

import java.io.*;
import java.util.ArrayList;

public class MemberReport{
    private String memberName;
    private String memberNumber;
    private String memberAddress;
    private String memberCity;
    private String memberState;
    private String memberZIP;
    private ArrayList<ServiceData> service = new ArrayList<ServiceData>();
    private int numOfConsults = service.size();
    private String serviceDate;
    private String providerName;
    private String serviceName;

    public MemberReport(MemberData obj){
        memberName = obj.getMemberName();
        memberNumber = obj.getMemberNumber();
        memberAddress = obj.getMemberAddress();
        memberCity = obj.getMemberCity();
        memberState = obj.getMemberState();
        memberZIP = obj.getMemberZIP();
        service = obj.getServiceList();
        numOfConsults = service.size();
    }
    

    public void printMemberReport() throws IOException{
        FileWriter file = new FileWriter(memberName+".txt");
        PrintWriter writing = new PrintWriter(file);

        writing.println("Member name: " + memberName);
        writing.println("Member number: " + memberNumber);
        writing.println("Member street address: " + memberAddress);
        writing.println("Member city: " + memberCity);
        writing.println("Member state: " + memberState);
        writing.println("Member ZIP code: " + memberZIP);
        printServiceData(writing);
        writing.close();
    }

    public void printServiceData(PrintWriter write) throws IOException{
		for(int x = 0; x < service.size(); x++){
		  write.println("Date of service: " + service.get(x).getServiceDate());
          write.println("Provider name: " + service.get(x).getProviderName()); 
		  write.println("Service name: " + service.get(x).getServiceName());
		  write.println();
		}
	}

}
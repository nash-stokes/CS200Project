package main;

import java.io.*;
import java.util.ArrayList;

/**
 * The Member Report class writes individual files for each member 
 * that contains their consultation information.
 * @author Lyle Stokes
 */
public class MemberReport{
    /**
     * The name of the member.
     */
    private String memberName;

    /**
     * The unique number assigned to each member
     */
    private String memberNumber;

    /**
     * The address of the member.
     */
    private String memberAddress;

    /**
     * The city of the member.
     */
    private String memberCity;

    /**
     * The state of the member.
     */
    private String memberState;

    /**
     * The ZIP code of the member.
     */
    private String memberZIP;

    /**
     * The array of services provided to the member.
     */
    private ArrayList<ServiceData> service = new ArrayList<ServiceData>();

    /**
     * The number of consulations provided to the member.
     */
    private int numOfConsults;

    /**
     * Takes a member object to specify which member's report is being generated
     * and all of their info.
     * @param obj
     */
    public MemberReport(MemberData obj){
        memberName = obj.getName();
        memberNumber = obj.getMemberNumber();
        memberAddress = obj.getStreet();
        memberCity = obj.getCity();
        memberState = obj.getState();
        memberZIP = obj.getZIP();
        service = obj.getServiceList();
        numOfConsults = service.size();
    }
    
    /**
     * Creates the individual member files and prints the member data and services
     * provided.
     * @throws IOException
     */
    public void printMemberReport() throws IOException{
        File memberReports = new File("memberReports");
        memberReports.mkdir();
        FileWriter file = new FileWriter("memberReports/" + memberNumber+".txt");
        PrintWriter writing = new PrintWriter(file);

        writing.println("Member name: " + memberName);
        writing.println("Member number: " + memberNumber);
        writing.println("Member street address: " + memberAddress);
        writing.println("Member city: " + memberCity);
        writing.println("Member state: " + memberState);
        writing.println("Member ZIP code: " + memberZIP);
        writing.println();
        printServiceData(writing);
        writing.close();
    }

    /**
     * Iterates through the list of services provided to member
     * and prints details to member's file.
     * @param write
     * @throws IOException
     */
    public void printServiceData(PrintWriter write) throws IOException{
		for(int x = 0; x < numOfConsults; x++){
      write.println("Date of service: " + service.get(x).getServiceDate());
      write.println("Provider name: " + service.get(x).getProviderName()); 
		  write.println("Service name: " + service.get(x).getServiceName());
		  write.println();
		}
	}

}
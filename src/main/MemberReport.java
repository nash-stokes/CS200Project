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

    FileOutputStream out = null;

    public void printMemberReport(){
        memberName = getMemberName();
        memberNumber = getMemberNumber();
        memberAddress = getMemberAddress();
        memberCity = getMemberCity();
        memberState = getMemberState();
        memberZip = getMemberZIP();
        serviceInfo = getServiceInfo();

        out = new FileOutputStream("MemberReport.txt");

        System.out.println("Member Name: " + memberName);
        System.out.println("Member Number: " + memberNumber);
        System.out.println("Member Address: " + memberAddress);
        System.out.println("Member City: " + memberCity);
        System.out.println("Member State: " + memberState);
        System.out.println("Member ZIP: " + memberZIP);
        System.out.println("Service Information: " + serviceInfo);
        
    }
}
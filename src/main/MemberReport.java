import java.io.*;

public class MemberReport{
    private String memberName;
    private String memberNumber;
    private String memberAddress;
    private String memberCity;
    private String memberState;
    private String memberZIP;
    private String serviceInfo;

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
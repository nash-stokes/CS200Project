package main;

import java.io.IOException;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.PrintWriter;

public class ServiceController {

    private static ArrayList<ServiceData> serviceList = new ArrayList<ServiceData>();
    private static float totalFee = 0;
    private static float individualFee = 0;

    public static void addService() {
        String providerNumber = IOController.getString();
        String memberNumber = IOController.getString();

        ServiceData x = new ServiceData(IOController.getString(), IOController.getString(), providerNumber, memberNumber, IOController.getString(), IOController.getString(), IOController.getDouble());

        serviceList.add(x);
        ProviderController.addService(providerNumber, x);
        MemberController.addService(memberNumber, x);
    }

    public static void emailPDFFile() throws IOException {
        FileWriter file = new FileWriter("Provider_Directory.txt");
        PrintWriter writing = new PrintWriter(file);

        for (int i = 0; i < ProviderDirectoryData.getSize(); i++) {
            writing.print(ProviderDirectoryData.getServiceNames(i) + " ");
            writing.print(ProviderDirectoryData.getServiceCodes(i) + " ");
            writing.println(ProviderDirectoryData.getServiceFees(i));
        }

        writing.close();
    }


    public static int getCountServices() {
        return serviceList.size();
    }

    public static double getTotalFee() {
        double x = 0;
        for (int i = 0; i < serviceList.size(); i++) {
            x += serviceList.get(i).getServiceFee();
        }

        return x;
    }

    public static ArrayList<ServiceData> getServiceList() {
         return serviceList;
    }
}

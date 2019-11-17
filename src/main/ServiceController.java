package main;

import java.io.IOException;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.PrintWriter;

public class ServiceController {

    private ArrayList<ServiceData> serviceList = new ArrayList<ServiceData>();
    private int countServices = 0;
    private int numProviders = 0;
    private float totalFee = 0;
    private float individualFee = 0;

    public void addService() {
        String providerNumber = IOController.getString();
        String memberNumber = IOController.getString();

        ServiceData x = new ServiceData(IOController.getString(), IOController.getString(), providerNumber, memberNumber, IOController.getString(), IOController.getString(), IOController.getDouble());

        serviceList.add(x);
        ProviderController.addService(providerNumber, x);
        MemberController.addService(memberNumber, x);
    }

    public void emailPDFFile() throws IOException {
        FileWriter file = new FileWriter("Provider_Directory.txt");
        PrintWriter writing = new PrintWriter(file);

        for (int i = 0; i < ProviderDirectoryData.getSize(); i++) {
            writing.print(ProviderDirectoryData.getServiceNames(i) + " ");
            writing.print(ProviderDirectoryData.getServiceCodes(i) + " ");
            writing.println(ProviderDirectoryData.getServiceFees(i));
        }

        writing.close();
    }


    public int getCountServices() {
        return countServices;
    }

    public float getTotalFee() {
        return totalFee;
    }

    public ArrayList<ServiceData> getServiceList() {
         return serviceList;
    }
}

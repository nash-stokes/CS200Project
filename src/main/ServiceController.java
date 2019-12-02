/**
 * This class is responsible for holding the services that have been performed,
 * modifying the storage of the services, and handling the provider directory.
 *
 * @author Jonathan Pence
 * @version 1.0
 */

package main;

import java.io.IOException;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.PrintWriter;

public class ServiceController {

    /**
     * ArrayList which stores all services that have been performed.
     */
    private static ArrayList<ServiceData> serviceList = new ArrayList<ServiceData>();

    /**
     * Float that stores the total fee of all services.
     */
    private static float totalFee = 0;

    /**
     * Prompts the user to add a service to the service data arraylist. The method continually prompts for information then aggregates it
     * into a ServiceData constructor, at which point it saves that new ServiceData object into the arraylist. Furthermore, it
     * stores the ServiceData into the proper provider/member service arraylists.
     */
    public static void addService() {
        IOController.output("Enter the provider number.");
        String providerNumber = IOController.getString();

        IOController.output("Enter the member number.");
        String memberNumber = IOController.getString();

        IOController.output("Enter the following information in this order: service date, service time, service code, optional comments (if none just leave blank), service fee, member name, service name, and provider name.");

        ServiceData x = new ServiceData(IOController.getString(), IOController.getString(), providerNumber,
                memberNumber, IOController.getString(), IOController.getString(), IOController.getDouble(), IOController.getString(), IOController.getString(), IOController.getString());

        serviceList.add(x);
        ProviderController.addService(providerNumber, x);
        MemberController.addService(memberNumber, x);

        IOController.output("Service successfully catalogued!");
    }

    /**
     * Attempts to write the provider directory data into a file called Provider_Directory.txt. If this is unable to happen, it
     * excepts and lets the user know that the file was unable to be found.
     */
    public static void emailPDFFile() {
        try {
            FileWriter file = new FileWriter("Provider_Directory.txt");
            PrintWriter writing = new PrintWriter(file);

            for (int i = 0; i < ProviderDirectoryData.getSize(); i++) {
                writing.print(ProviderDirectoryData.getServiceNames(i) + " ");
                writing.print(ProviderDirectoryData.getServiceCodes(i) + " ");
                writing.println(ProviderDirectoryData.getServiceFees(i));
            }
            writing.close();
        }

        catch (IOException e) {
            System.out.println("File not found");
        }

    }

    /**
     * Get function for the amount of services performed.
     *
     * @return an integer representation of the cumulative number of services performed.
     */
    public static int getCountServices() {
        return serviceList.size();
    }

    /**
     * Get function for the cumulative fee of all services performed.
     *
     * @return a double representation of the cumulative fee of all services performed.
     */
    public static double getTotalFee() {
        double x = 0;
        for (int i = 0; i < serviceList.size(); i++) {
            x += serviceList.get(i).getServiceFee();
        }

        return x;
    }

    /**
     * Get function for the ServiceData ArrayList of all services.
     *
     * @return an ArrayList<ServiceData> which stores all the services performed.
     */
    public static ArrayList<ServiceData> getServiceList() {
        return serviceList;
    }
}

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
     * Prompts the user to add a service to the service data arraylist. The method continually prompts for information then aggregates it
     * into a ServiceData constructor, at which point it saves that new ServiceData object into the arraylist. Furthermore, it
     * stores the ServiceData into the proper provider/member service arraylists.
     */
    public static void addService(String providerNumber) {

        boolean memberValidated = false;
        IOController.output("Enter the member number.");
        String memberNumber = "x";

        while (!memberValidated && !memberNumber.equals("-1")) {
            memberNumber = IOController.getString();

            if (MemberController.validateCode(memberNumber))
                memberValidated = true;

            else
                IOController.output("Invalid member number. Retry, or enter -1 to exit.");
        }

        if (memberNumber.equals("-1"))
            return;

        IOController.output("Enter service date in format mm-dd-yyyy:");
        String serviceDate = IOController.getString();

        IOController.output("Enter service time in format hh:mm:ss");
        String serviceTime = IOController.getString();

        boolean exists = false;
        boolean validated = false;
        String serviceCode = "x";

        while (!exists && !validated && !serviceCode.equals("-1")) {
            IOController.output("Enter service code:");
            serviceCode = IOController.getString();

            if (ProviderDirectoryData.exists(serviceCode)) {
                exists = true;
            }

            else
            {
                IOController.output("Nonexistent service code. Retry, or enter -1 to exit.");
            }

            if (exists && ProviderDirectoryData.validate(serviceCode)) {
                validated = true;
            }

            else {
                exists = false;
            }
        }

        if (serviceCode.equals("-1"))
            return;

        IOController.output("Enter option comment in one line:");
        String comment = IOController.getString();

        ServiceData x = new ServiceData(serviceDate, serviceTime, providerNumber, memberNumber, serviceCode, comment, ProviderDirectoryData.fillFee(serviceCode), MemberController.fillName(memberNumber), ProviderDirectoryData.fillName(serviceCode), ProviderController.fillName(providerNumber));

        serviceList.add(x);
        ProviderController.addService(providerNumber, x);
        MemberController.addService(memberNumber, x);

        IOController.output("Service successfully catalogued!");
    }

    /**
     * Attempts to write the provider directory data into a file called Provider_Directory.txt. If this is unable to happen, it
     * excepts and lets the user know that the file was unable to be found.
     */
    public static void emailPDFFile(){
        try {
            FileWriter file = new FileWriter("Provider_Directory.txt");
            PrintWriter writing = new PrintWriter(file);
            for (int i = 0; i < ProviderDirectoryData.getSize(); i++) {
                writing.print(ProviderDirectoryData.getServiceNames(i) + " ");
                writing.print(ProviderDirectoryData.getServiceCodes(i) + " ");
                writing.println(ProviderDirectoryData.getServiceFees(i));
            }
            writing.close();
            file.close();
        }

        catch (IOException e) {
            System.out.println("Provider_Directory.txt not found");
        }

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

package main;

import java.io.*;

/**
 * The EFTFileData class stores the providers to be paid and how much to pay
 * them.
 * 
 * @author Lyle Stokes
 */
public class EFTFileData {
    /**
     * Iterates through provider list, printing provider info and fees in created
     * file
     */
    public static void printEFTReport() {
        try {
            FileWriter file = new FileWriter("EFTFileData.txt");
            PrintWriter writing = new PrintWriter(file);
            double sum = 0;
            int numServ = 0;
            for (int i = 0; i < ProviderController.getProviderList().size(); i++) {
                writing.println("Provider name: " + ProviderController.getProviderList().get(i).getName());
                writing.println("Provider number: " + ProviderController.getProviderList().get(i).getProviderNumber());
                numServ = ProviderController.getProviderList().get(i).getServiceList().size();
                for(int j = 0; j < numServ; j++) {
                	sum = sum + ProviderController.getProviderList().get(i).getServiceList().get(j).getServiceFee();
                }
                writing.println("Total fee for period: $" + sum);
                writing.println();
                sum = 0;
            }
            writing.close();
        }

        catch (IOException e) {
            System.out.println("File not found.");
        }
    }
}
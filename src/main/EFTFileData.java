
package main;

import java.io.*;

/**
 * The EFTFileData class stores the providers to be paid and how much to pay them.
 * @author Lyle Stokes
 */
public class EFTFileData{
    /**
     * Iterates through provider list, printing provider info and fees in created file
     * @throws IOException
     */
    public static void printEFTReport() throws IOException{
        FileWriter file = new FileWriter("EFTFileData.txt");
        PrintWriter writing = new PrintWriter(file);
        for (int i = 0; i < ProviderController.getProviderList().size(); i++){
            writing.println("Provider name :" + ProviderController.getProviderList().get(i).getName());
            writing.println("Provider number :" + ProviderController.getProviderList().get(i).getProviderNumber());
            writing.println("Total fee for period :" + (int)(Math.random() * 41 * 15));
        }
        writing.close();
    }
}
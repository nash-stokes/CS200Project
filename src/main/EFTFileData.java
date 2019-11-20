
package main;

import java.io.*;
import java.util.ArrayList;

/**
 * The EFTFileData class stores the providers to be paid and how much to pay them.
 * @author Lyle Stokes
 */
public class EFTFileData{
    String providerName;
    String providerNumber;
    float transferAmount;

    public String getProviderName(){
        return providerName;
    }

    public void setProviderName(final String providerName) {
        this.providerName = providerName;
    }

    public String getProviderNumber() {
        return providerNumber;
    }

    public void setProviderNumber(final String providerNumber) {
        this.providerNumber = providerNumber;
    }

    public float getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(final float transferAmount) {
        this.transferAmount = transferAmount;
    }
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
            //Get Simon to write getTotalFee method
            writing.println("Total fee for period :" + ProviderController.calculateFee(ProviderController.getProviderList().get(i).getProviderNumber()));
        }
        
    }
}
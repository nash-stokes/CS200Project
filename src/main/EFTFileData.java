//Nash
package main;

import java.io.*;

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

    // for(int i = 0; i < ProviderController.getProviderList.size; i++){
    //     FileWriter file = new FileWriter("EFTFileData.txt");
    //     file print providerController.getProviderList.get(i).getName;
    //     file print ...getNumber;
    //     file print providerController.calculateFee(providerController.getProviderList.get(i).getProviderNumber);
    // }
}
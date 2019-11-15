<<<<<<< HEAD
package main;

public class EFTFileData{
    String providerName;
    String providerNumber;
    float transferAmount;

    public String getProviderName(){
        return providerName;
    }

    public void setProviderName(String providerName){
        this.providerName = providerName;
    }

    public String getProviderNumber(){
        return providerNumber;
    }

    public void setProviderNumber(String providerNumber){
        this.providerNumber = providerNumber;
    }

    public float getTransferAmount(){
        return transferAmount;
    }

    public void setTransferAmount(float transferAmount){
        this.transferAmount = transferAmount;
    }
=======
public class EFTFileData{
    private String providerName;
    private String providerNumber;
    private float transferAmount;

    public String getProviderName(){
        return providerName;
    }

    public void setProviderName(String providerName){
        this.providerName = providerName;
    }

    public String getProviderNumber(){
        return providerNumber;
    }

    public void setProviderNumber(String providerNumber){
        this.providerNumber = providerNumber;
    }

    public float getTransferAmount(){
        return transferAmount;
    }

    public void setTransferAmount(float transferAmount){
        this.transferAmount = transferAmount;
    }
>>>>>>> e6799b853e34f322b7becad3a95d7487a4081d3a
}
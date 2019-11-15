public Class EFTFileData{
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

    public void setProviderName(String providerNumber){
        this.providerNumber = providerNumber;
    }

    public float getTransferAmount(){
        return transferAmount;
    }

    public void setTransferAmount(float transferAmount){
        this.transferAmount = transferAmount;
    }
}
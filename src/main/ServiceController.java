public class ServiceController {
    /*
     * The below attributes must be uncommented when the proper data classes are
     * implemented private MemberData memberList[]; private ServiceData
     * serviceList[]; private ProviderData providerList[];
     */
    private int countServices;
    private int numProviders;
    private float totalFee;
    private float individualFee;

    public void addService() {
        /*
         * This function shall: 1. Be called when the user selects to add a service to
         * the list of services. 2. Prompt the user to enter: service date, service time
         * provider number, member number, service code, and option- al comments. 3.
         * Generate a new ServiceData object with the attributes being filled by their
         * respective above values. 4. Prompt the user that the present data is correct
         * 5. Store the new object within serviceList[] 6. Terminate
         */
    }

    public void emailPDFFile() {
        /*
         * This function shall: 1. Be called when the user requests a Provider Directory
         * 2. Access ProviderDirectoryInformation and funnel all necessary data into
         * this function 3. Aggregate all this function and write it to a text file 4.
         * Inform the user that the file has been created 5. Terminate
         */
    }

    public boolean validateMember() {
        /*
         * This function shall: 1. Be called whenever it is necessary that the existence
         * of a member be validated 2. Prompt the user to input service code/member name
         * 3. Iterate through the list of members 4. Return true if a user is found with
         * matching credentials 5. Return falls if no user is found 6. If true, have
         * user validate the information 7. Validate the member 8. Terminate
         */
        return false;
    }

    public boolean validateProvider() {
        // Do the same as the above, just with provider info.
        return false;
    }

    public int getCountServices() {
        return countServices;
    }

    public float getTotalFee() {
        return totalFee;
    }

    // UNCOMMENT ONCE DATA CLASS IMPLEMENTED
    // public ServiceData[] getServiceList() {
    // return serviceList;
    // }
}

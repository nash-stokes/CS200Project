/**
 * This class is responsible for triggering the generation of the different types
 * of reports available.
 *
 * @author Jonathan Pence
 * @version 1.0
 */

package main;

import java.io.IOException;
import java.util.ArrayList;

public class ReportController {
<<<<<<< HEAD
    /**
     * Triggers the accounts payable report to be generated and printed.
     * @throws IOException
     */
    public void generateAccountsPayable() throws IOException {
        AccountsPayableReport.printAccountsPayableReport();
    }

    /**
     * Generates and prints a provider report for each provider found in the
     * provider controller.
     * @throws IOException
     */
    public void generateProviderReport() throws IOException { // finish this
    ArrayList<ProviderData> providerList = ProviderController.getProviderList();
    for (int i = 0; i < providerList.size(); i++) {
        ProviderReport x = new ProviderReport(providerList.get(i));
        x.printProviderReport();
=======
    public void generateAccountsPayable() {
        try {
            AccountsPayableReport.printAccountsPayableReport();

        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

    public void generateProviderReport() { // finish this
        ArrayList<ProviderData> providerList = ProviderController.getProviderList();
        for (int i = 0; i < providerList.size(); i++) {
            ProviderReport x = new ProviderReport(providerList.get(i));
            try {
                x.printProviderReport();
            } catch (IOException e) {
                System.out.println("File not found");
            }

        }
>>>>>>> 9141d58b5ce436db562ea042a2a2a6cec1dcbcdf
    }

    /**
     * Generates and prints a member report for each member found within the
     * member controller.
     * @throws IOException
     */
    public void generateMemberReport() throws IOException { // Error should resolve when Nash finishes his classes
        ArrayList<MemberData> memberList = MemberController.getMemberList();
        for (int i = 0; i < memberList.size(); i++) {
            MemberReport x = new MemberReport(memberList.get(i));
            try {
                x.printMemberReport();
            }

            catch (IOException e) {
                System.out.println("File not found");
            }

        }
    }

<<<<<<< HEAD
    /**
     * Triggers the generation and printing of the EFT report.
     * @throws IOException
     */
    public void generateEFTFile() throws IOException { //Error should resolve when Nash finishes his classes
=======
    public void generateEFTFile() { // Error should resolve when Nash finishes his classes
>>>>>>> 9141d58b5ce436db562ea042a2a2a6cec1dcbcdf
        EFTFileData.printEFTReport();
    }
}

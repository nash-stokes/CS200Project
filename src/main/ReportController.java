package main;

import java.io.IOException;
import java.util.ArrayList;

public class ReportController {
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
    }

    public void generateMemberReport() { // Error should resolve when Nash finishes his classes
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

    public void generateEFTFile() { // Error should resolve when Nash finishes his classes
        EFTFileData.printEFTReport();
    }
}

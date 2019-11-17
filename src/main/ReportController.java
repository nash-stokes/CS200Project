package main;

import java.io.IOException;
import java.util.ArrayList;

public class ReportController {
    public void generateAccountsPayable() {
        AccountsPayableReport.printAccountsPayableReport();
    }

    public void generateProviderReport() throws IOException {
        ArrayList<ProviderData> providerList = ProviderController.getProviderList();
        for (int i = 0; i < providerList.size(); i++) {
            ProviderReport x = new ProviderReport(...);
            x.printProviderReport();
        }
    }

    public void generateMemberReport() { // finish this
        ArrayList<MemberData> memberList = MemberController.getMemberList();
        for (int i = 0; i < memberList.size(); i++) {
            MemberReport x = new MemberReport(...);
            x.printMemberReport();
        }
    }

    public void generateEFTFile() {
        EFTFileData.printEFTReport();
    }
}

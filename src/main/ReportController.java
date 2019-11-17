package main;

import java.io.IOException;
import java.util.ArrayList;

public class ReportController {
    public void generateAccountsPayable() throws IOException {
        AccountsPayableReport.printAccountsPayableReport();
    }

    public void generateProviderReport() throws IOException { // finish this
    ArrayList<ProviderData> providerList = ProviderController.getProviderList();
    for (int i = 0; i < providerList.size(); i++) {
        ProviderReport x = new ProviderReport(providerList.get(i));
        x.printProviderReport();
    }
}

    public void generateMemberReport() { // Error should resolve when Nash finishes his classes
        ArrayList<MemberData> memberList = MemberController.getMemberList();
        for (int i = 0; i < memberList.size(); i++) {
            MemberReport x = new MemberReport(memberList.get(i));
            x.printMemberReport();
        }
    }

    public void generateEFTFile() { //Error should resolve when Nash finishes his classes
        EFTFileData.printEFTReport();
    }
}

package main;

import main.ReportController;;

public class ManagerTerminal {
  public static void run() {
    while (true) {

      System.out.println("Please input the type of report you want to request");
      System.out.println("0 - Accounts Payable Report");
      System.out.println("1 - Provider Report");
      System.out.println("2 - Member Report");
      System.out.println("3 - EFT File");
      System.out.println("4 - Quit");

      int reportType = IOController.getInt();
      while (reportType < 0 || reportType > 4) {
        System.out.println("Invalid report type, please try again.");
        reportType = IOController.getInt();
      }
      System.out.print("LOL");

      if (reportType == 4) {
        break;
      } else {
        switch (reportType) {
        case 0:
          ReportController.generateAccountsPayable();
          break;
        case 1:
          ReportController.generateProviderReport();
          break;
        case 2:
          ReportController.generateMemberReport();
          break;
        case 3:
          ReportController.generateEFTFile();
          break;
        }
      }
      System.out.println("OK");

    }
  }
}

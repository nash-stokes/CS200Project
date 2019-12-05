/**
 * @author An Thien Duong Do
 * 
 * This class acts as the virtual Manager Terminal. From here, users are granted the ability to run calculations on a variety of reports. Furthermore, they may choose
 * to run the main accounting procedure.
 */

package main;

public class ManagerTerminal {
  
  /**
   * This function prompts the user for input in determining which report they wish to calculate and print, or whether or not they'd like to run the main accounting procedure.
   */
  public static void run() {
    while (true) {

      System.out.println("Please input the type of report you want to request");
      System.out.println("0 - Accounts Payable Report");
      System.out.println("1 - Provider Report");
      System.out.println("2 - Member Report");
      System.out.println("3 - EFT File");
      IOController.output("4 - Run Main Accounting Procedure");
      System.out.println("5 - Quit");

      int reportType = IOController.getInt();
      if (reportType == 5)
        return;

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
          case 4:
            MainAccountingController.getWeeklyReport();
            break;
          default:
            IOController.output("Invalid selection. Try again.");
            break;
        }
      }
  }
}

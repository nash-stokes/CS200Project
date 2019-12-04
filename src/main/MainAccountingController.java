/** Name: Do Thien An Duong
 * CWID: 11895098
 */
package main;


public class MainAccountingController {
  public static void getWeeklyReport() {
      ReportController.generateAccountsPayable();
      ReportController.generateEFTFile();
      ReportController.generateMemberReport();
      ReportController.generateProviderReport();
    }
}


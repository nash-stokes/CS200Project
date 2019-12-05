/** Name: Do Thien An Duong
 * CWID: 11895098
 */
package main;


public class MainAccountingController {
  
  /**
   * This function aggregates the different report generation functions into one, so that they can all be
   * generated in unison with one another without having to run them one-by-one manually.
   */
  public static void getWeeklyReport() {
      ReportController.generateAccountsPayable();
      ReportController.generateEFTFile();
      ReportController.generateMemberReport();
      ReportController.generateProviderReport();
    }
}


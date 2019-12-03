/** Name: Do Thien An Duong
 * CWID: 11895098
 */

package main;

import main.ServiceController;
import main.ProviderController;
import main.MemberController;

public class ProviderTerminal {
  /**
   * Calls ServiceController to email the PDF file of Provider Directory to the
   * provider if they are authenticated
   */
  static void getProviderDirectory() {
    ServiceController.emailPDFFile();
  }

  void manageService() {

  }

  public static void run() {
    boolean authenticated = ProviderController.validateProvider();
    if (authenticated) {
      System.out.println("Please choose your actions:");
      System.out.println("");
      boolean valid = MemberController.validateMember();
      if (valid) {
        System.out.println("Validated");
      }
    }

  }
}

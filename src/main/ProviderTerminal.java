/** Name: Do Thien An Duong
 * CWID: 11895098
 */

package main;

import main.ServiceController;
import main.ProviderController;

public class ProviderTerminal {
  boolean authenticated = false;

  /**
   * Calls ServiceController to email the PDF file of Provider Directory to the
   * provider if they are authenticated
   */
  void getProviderDirectory() {
    if (authenticated)
      ServiceController.emailPDFFile();
  }

  void manageService() {

  }

  /**
   * Calls the provider controller to validate the provider
   */
  void authenticateProvider() {
    authenticated = ProviderController.validateProvider();
  }
}

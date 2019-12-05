/** Name: Do Thien An Duong CWID: 11895098 */
package main;

public class ProviderTerminal {
  /**
   * Function which handles the actions that providers wish to take. Rejects providers whose numbers
   * do not validate.
   */
  public static void run(String providerNumber) {
    int action = 0;
    while (action != 2) {
      System.out.println("Please choose your actions:");
      System.out.println("0 - Add Service");
      IOController.output("1 - Request Provider Directory");
      IOController.output("2 - Exit");

      action = IOController.getInt();

      switch (action) {
        case 0:
          ServiceController.addService(providerNumber);
          break;
        case 1:
          ServiceController.emailPDFFile();
          break;
        case 2:
          return;
        default:
          IOController.output("Invalid choice.");
          break;
      }
    }
    return;
  }
}

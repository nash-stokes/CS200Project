/**
 * @author An Thien Duong Do
 *     <p>This file funnels users to and from different terminals based upon their input.
 *     Furthermore, it locks the provider terminal behind a rudimentary verification process.
 */
package main;

public class MainApplication {

  /**
   * This is our main function. No parameters are truly passed in. This function is responsible for
   * prompting the user to select a certain terminal, accepting user input to determine which
   * terminal they are funneled to, and then handling user interaction when that terminal session is
   * ended.
   */
  public static void main(String[] args) {

    ProviderDirectoryData.readFile();

    while (true) {
      System.out.println("Which terminal do you want to access?");
      System.out.println("1 - Manager Terminal");
      System.out.println("2 - Operator Terminal");
      System.out.println("3 - Provider Terminal");
      System.out.println("4 - Quit");
      int input = main.IOController.getInt();
      if (input == 4) {
        break;
      } else {
        switch (input) {
          case 1:
            ManagerTerminal.run();
            break;
          case 2:
            OperatorTerminal.run();
            break;
          case 3:
            IOController.output("Enter provider number to log-in.");
            String providerNumber = IOController.getString();
            if (ProviderController.validateCode(providerNumber))
              ProviderTerminal.run(providerNumber);
            else IOController.output("Invalid provider code.");
            break;
          default:
            System.out.print("Input should only be from 1 to 4");
            break;
        }
      }
    }
  }
}

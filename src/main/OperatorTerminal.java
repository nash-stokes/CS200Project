package main;

/**
 * The Operator Terminal class stores the providers to be paid and how much to pay them.
 *
 * @author Lyle Stokes
 */
public class OperatorTerminal {
  /**
   * Takes parameters to carryout operator's intended action. 0 represents a member account action.
   * 1 represents a provider account action.
   *
   * @param accType determines account type to be operated on
   * @param action determines action to perform on account
   */
  public static void manageAccount(int accType, int action) {
    if (accType == 0) {
      if (action == 0) {
        MemberController.addMember();
      } else if (action == 1) {
        MemberController.deleteMember();
      } else if (action == 2) {
        MemberController.updateMember();
      } else if (action == 3) {
        MemberController.validateMember();
      }
    } else if (accType == 1) {
      if (action == 0) {
        ProviderController.addProvider();
      } else if (action == 1) {
        ProviderController.deleteProvider();
      } else if (action == 2) {
        ProviderController.updateProvider();
      } else if (action == 3) {
        ProviderController.validateProvider();
      }
    }
  }

  /**
   * This function is responsible for prompting the user what account type they would like to
   * interact with. Furthermore, it will also prompt the user for what kind of operation they would
   * like to perform on that acount type.
   */
  public static void run() {
    while (true) {

      System.out.println("Please input the account type");
      System.out.println("0 - Member Account");
      System.out.println("1 - Provider Account");
      IOController.output("2 - Exit");

      int accType = IOController.getInt();
      while (accType < 0 || accType > 2) {
        System.out.println("Invalid account type, please try again.");
        accType = IOController.getInt();
      }

      if (accType == 2) return;

      System.out.println("Please input the action wanted:");
      System.out.println("0 - Add");
      System.out.println("1 - Delete");
      System.out.println("2 - Update");
      System.out.println("3 - Validate");
      int action = IOController.getInt();

      while (action < 0 || action > 3) {
        System.out.println("Invalid action, please try again.");
        action = IOController.getInt();
      }

      manageAccount(accType, action);
    }
  }
}

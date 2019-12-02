package main;

import main.IOController;

/**
 * The Operator Terminal class stores the providers to be paid and how much to
 * pay them.
 * 
 * @author Lyle Stokes
 */
<<<<<<< HEAD
public class OperatorTerminal {
  /**
   * Takes parameters to carryout operator's intended action. 0 represents a
   * member account action. 1 represents a provider account action.
   * 
   * @param accType determines account type to be operated on
   * @param action  determines action to perform on account
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

  public static void run() {
    while (true) {

      System.out.println("Please input the account type");
      System.out.println("0 - Member Account");
      System.out.println("1 - Provider Account");

      int accType = IOController.getInt();
      while (accType < 0 || accType > 1) {
        System.out.println("Invalid account type, please try again.");
        accType = IOController.getInt();
      }

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
=======
public class OperatorTerminal{
    /**
     * Takes parameters to carryout operator's intended action.
     * 0 represents a member account action.
     * 1 represents a provider account action.
     * @param accType determines account type to be operated on
     * @param action determines action to perform on account
     */
	public void manageAccount(boolean accType, int action){
        if (!accType){
            if (action == 0){
                MemberController.addMember();
            }
            else if(action == 1){
                MemberController.deleteMember();
            }
            else if(action == 2){
                MemberController.updateMember();
            }
            else if(action == 3){
                MemberController.validateMember();
            }
        }
        else{
            if (action == 0){
                ProviderController.addProvider();
            }
            else if(action == 1){
                ProviderController.deleteProvider();
            }
            else if(action == 2){
                ProviderController.updateProvider();
            }
            else if(action == 3){
                ProviderController.validateProvider();
            }
        }
>>>>>>> d57f86f4b3ce9086909b63f40fe3cb004499a986
    }
  }
}
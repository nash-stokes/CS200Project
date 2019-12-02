package main;

/**
 * The Operator Terminal class stores the providers to be paid and how much to pay them.
 * @author Lyle Stokes
 */
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
    }
}
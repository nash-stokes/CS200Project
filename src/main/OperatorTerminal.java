//Nash
package main;

public class OperatorTerminal{
    public void manageAccount(boolean accType, int action){
        //MEMBER OPERATIONS
        if (accType == 0){
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
        //PROVIDER OPERATIONS
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
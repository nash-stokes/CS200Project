public class OperatorTerminal{
    public void manageAccount(boolean accType, int action){
        //MEMBER OPERATIONS
        if (accType == 0){
            if (action == 0){
                addMember();
            }
            else if(action == 1){
                deleteMember();
            }
            else if(action == 2){
                updateMember();
            }
            else if(action == 3){
                validateMember();
            }
        }
        //PROVIDER OPERATIONS
        else{
            if (action == 0){
                addProvider();
            }
            else if(action == 1){
                deleteProvider();
            }
            else if(action == 2){
                updateProvider();
            }
            else if(action == 3){
                validateProvider();
            }
        }
    }
}
package main;

import main.ManagerTerminal;
import main.OperatorTerminal;
import main.ProviderTerminal;
import main.IOController;

public class MainApplication {
  public static void main(String[] args) {
    System.out.println("Which terminal do you want to access?");
    System.out.println("1 - Manager Terminal");
    System.out.println("2 - Operator Terminal");
    System.out.println("3 - Provider Terminal");
    System.out.println("4 - Quit");
    while (true) {
      int input = main.IOController.getInt();
      if (input == 4) {
        break;
      }

      else {
        switch (input) {
        case 1:
          ManagerTerminal.run();
          break;
        case 2:
          OperatorTerminal.run();
          break;
        case 3:
          // ProviderTerminal.run();
          break;
        default:
          System.out.print("Input should only be from 1 to 4");
          break;
        }
      }
    }
  }
}
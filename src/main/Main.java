package main;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author Lyle Stokes
 * 
 * This program gets user input and triggers the correct terminal.
 */

public class Main {
	
	public static void main(String args[]) {
		System.out.println("Options:");
		System.out.println("0 - Manager Terminal");
		System.out.println("1 - Operator Terminal");
		System.out.println("2 - Provider Terminal");
		
		Scanner input = new Scanner(System.in);
		
		int number = input.nextInt();
		
		if(number == 0) {
			//ManagerTerminal;
		}
		else if (number == 1) {
			//OperatorTerminal;
		}
		else if (number == 2) {
			//ProviderTerminal;
		}
		else {
			System.out.println("Error: Entered option does not exist");
		}
	}
};

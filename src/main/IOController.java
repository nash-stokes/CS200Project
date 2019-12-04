/**
 * This class is responsible for managing input and output in a standardized way.
 *
 * @author Jonathan Pence
 * @version 1.0
 */
package main;

import java.util.Scanner;

public class IOController {

    /**
     * This is the Scanner object which is used ubiquitously for input.
     */
    static private Scanner kb = new Scanner(System.in);

    /**
     * Prompts the user for string input.
     *
     * @return the string inputted by the user.
     */
    static String getString() {
        return kb.nextLine();
    }

    /**
     * Prompts the user for an int input.
     *
     * @return the int inputted by the user.
     */
    static int getInt() {
        int x = kb.nextInt();
        kb.nextLine();

        return x;
    }

    /**
     * Prompts the user for a double input.
     *
     * @return the double inputted by the user.
     */
    static double getDouble() {
        double x = kb.nextDouble();
        kb.nextLine();

        return x;
    }

    /**
     * Outputs a string.
     *
     * @param x the string to be outputted.
     */
    static void output(String x) {
        System.out.println(x);
    }
}

package main;

import java.util.Scanner;

public class IOController {

    static private Scanner kb = new Scanner(System.in);

    static String getString() {
        String x = kb.nextLine();

        return x;
    }

    static float getFloat() {
        float x = kb.nextFloat();

        return x;
    }

    static int getInt() {
        int x = kb.nextInt();

        return x;
    }

    static double getDouble() {
        double x = kb.nextDouble();

        return x;
    }

    static void output(String x) {
        System.out.println(x);
    }
}

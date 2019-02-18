package by.bntu.fitr.java.inGoslingsFootsteps.Lab10.util;

import java.util.Scanner;

public class UserInput {

    public static int inputInt(String msg) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(msg);
        return scanner.nextInt();
    }

    public static String inputString(String msg) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(msg);
        return scanner.nextLine();
    }
}
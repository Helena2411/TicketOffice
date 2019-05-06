package by.bntu.fitr.java.inGoslingsFootsteps.Lab10.util;

import by.bntu.fitr.java.inGoslingsFootsteps.Lab10.util.exception.InputException;

import java.util.Scanner;

public class UserInput {

    public static int inputInt(String msg) throws InputException {
        Scanner scanner = new Scanner(System.in);
        System.out.println(msg);
        if(scanner.hasNextInt())
            return scanner.nextInt();
        else
            throw new InputException("You intered incorrect data. You should enter integer number");
    }

    public static String inputString(String msg) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(msg);
        return scanner.nextLine();
    }
}
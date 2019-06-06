package by.bntu.fitr.javalabs.ingosligsfootsteps.util;

import java.util.Scanner;

public class UserInput {
    public static int input(String msg) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(msg);
        return scanner.nextInt();
    }
}

package com.twu.biblioteca.util;

import java.util.Scanner;

public class UserInput {

    public static String obtainInput(String promptMessage) {
        System.out.print(promptMessage);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        System.out.println();
        return input;
    }
}

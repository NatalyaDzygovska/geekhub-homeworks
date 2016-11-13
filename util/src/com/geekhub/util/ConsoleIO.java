package com.geekhub.util;

import java.util.Scanner;

public class ConsoleIO {
    private static Scanner scanner = new Scanner(System.in);

    public static int getIntFromUser() {
        int userInput = scanner.nextInt();
        while (!scanner.hasNextInt()) {
            System.err.print("Wrong input, please enter a number: ");
        }
        return userInput;
    }

    public static int getIntFromUser(int min, int max) {
        int userInput = scanner.nextInt();
        while (userInput < min || userInput > max) {
            userInput = scanner.nextInt();
        }
        return userInput;
    }

    public static String getLineFromUser() {
        return scanner.nextLine();
    }

    public static String getWordFromUser() {
        return getLineFromUser().trim();
    }
}

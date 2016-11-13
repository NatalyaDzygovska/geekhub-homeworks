package com.geekhub.homework4.task2;

import com.geekhub.util.ConsoleIO;

public class Main {

    public static void main(String[] args) {
        Abbreviator abbreviator = new Abbreviator();

        abbreviator.setCountOfLines(getCountOfLines());
        System.out.println(abbreviator.getCountOfLines());

        inputWords(abbreviator);
        printAbbreviatedWords(abbreviator);
    }

    private static void printAbbreviatedWords(Abbreviator abbreviator) {
        abbreviator.getAbbreviatedWords().forEach(System.out::println);
    }

    private static void inputWords(Abbreviator abbreviator) {
        for (int i = 0; i <= abbreviator.getCountOfLines(); i++) {
            abbreviator.addWord(ConsoleIO.getWordFromUser());
        }
    }

    private static int getCountOfLines() {
        System.out.println("Please, enter count of lines: ");
        return ConsoleIO.getIntFromUser(1, 100);
    }
}

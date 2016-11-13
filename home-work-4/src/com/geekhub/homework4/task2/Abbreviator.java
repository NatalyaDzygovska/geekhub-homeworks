package com.geekhub.homework4.task2;

import java.util.ArrayList;
import java.util.List;

public class Abbreviator {
    private static final int LIMIT_LENGTH = 10;
    private int countOfLines;
    private List<String> AbbreviatedWords = new ArrayList<>();

    public void addWord(String word) {
        AbbreviatedWords.add(abbreviate(word));
    }

    private String abbreviate(String word) {
        if (word.length() >= LIMIT_LENGTH) {
            word = "" + word.charAt(0) + (word.length()-2) + word.charAt(word.length() - 1);
        }
        return word;
    }

    public void setCountOfLines(int countOfLines) {
        this.countOfLines = countOfLines;
    }

    public int getCountOfLines() {
        return countOfLines;
    }

    public List<String> getAbbreviatedWords() {
        return AbbreviatedWords;
    }

}

package com.chous.wordle;

import java.util.IllegalFormatCodePointException;

public class WordsRepository {
    private static WordsRepository instance;

    private WordsRepository() {
    }

    public static WordsRepository getInstance() {
        if (instance == null) {
            instance = new WordsRepository();
        }
        return instance;
    }


    private String word;
    private final String[] words = {"QWERT", "YUIOP", "ASDFG", "HJKLZ", "XCVBN", "CHOUS"};


    public void generateWord() {
        word = "chous".toUpperCase();
    }


    public String getWord() {
        return word;
    }


    public boolean isAttemptExist(String attempt) {
        for (String word : words) {
            if (word.equals(attempt)) {
                return true;
            }
        }
        return false;
    }
}

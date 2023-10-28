package com.chous.wordle;

public class WordsRepository {
    private static WordsRepository instance;

    private WordsRepository() { }

    public static WordsRepository getInstance() {
        if (instance == null) {
            instance = new WordsRepository();
        }
        return instance;
    }


    private String word;

    public void generateWord(){
        word = "chous".toUpperCase();
    }

    public String getWord() {
        return word;
    }

    public boolean isAttemptExist(String attempt) {
        return true;
    }
}

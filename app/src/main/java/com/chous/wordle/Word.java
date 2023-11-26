package com.chous.wordle;

public class Word {
    private Letter[] letters;

    Word(String word) {
        letters = new Letter[Game.WORDLE_LENGTH];
        for (int i = 0; i < letters.length; i++) {
            letters[i] = new Letter(word.substring(i, i + 1));
        }
    }

    public String getText() {
        StringBuilder word = new StringBuilder();
        for (Letter letter : letters) {
            word.append(letter.getText());
        }
        return word.toString().toUpperCase();
    }

    public Letter[] getLetters() {
        return letters;
    }

    public void checkAttempt(Word word) {
        Letter[] wordLetters = word.getLetters();
        for (int i = 0; i < letters.length; i++) {
            //In any case it will be absent or more
            if (letters[i].getStatus() == Letter.Status.NONE) {
                letters[i].setStatus(Letter.Status.ABSENT);
            }
            //Compare by elements and change both
            for (int num = 0; num < wordLetters.length; num++) {
                if (letters[i].getText().equals(wordLetters[num].getText())) {
                    if (i == num) {
                        letters[i].setStatus(Letter.Status.CORRECT);
                        wordLetters[num].setStatus(Letter.Status.CORRECT);
                    } else {
                        if (letters[i].getStatus() != Letter.Status.CORRECT) {
                            letters[i].setStatus(Letter.Status.PRESENT);
                        }
                        if (wordLetters[num].getStatus() != Letter.Status.CORRECT) {
                            wordLetters[num].setStatus(Letter.Status.PRESENT);
                        }
                    }
                }
            }
        }
    }

    public boolean compare(String wordToCompare){
        return getText().equals(wordToCompare);
    }

}

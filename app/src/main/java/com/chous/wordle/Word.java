package com.chous.wordle;

/**
 * The Word class represents a target word and attempts words in the Wordle game and encapsulates the logic for checking attempts.
 * It is responsible for initializing the word, retrieving its text, retrieving its individual letters,
 * checking an attempt against the target word, and comparing the target word to a provided attempt word for equality.
 * <p>
 * Note: we use uppercase everywhere to compare words correctly.
 *
 * @value <b>letters</b> - Array of Letter objects representing individual letters in the word.
 */
public class Word {
    private final Letter[] letters;

    /**
     * Constructor for the Word class. Initializes the array of Letter objects based on the provided word.
     *
     * @param word The string representation of the word.
     */
    Word(String word) {
        letters = new Letter[Game.WORDLE_LENGTH];
        for (int i = 0; i < letters.length; i++) {
            letters[i] = new Letter(word.substring(i, i + 1));
        }
    }

    /**
     * Retrieves the textual representation of the target word.
     *
     * @return The target word as a string in uppercase.
     */
    public String getText() {
        StringBuilder word = new StringBuilder();
        for (Letter letter : letters) {
            word.append(letter.getText());
        }
        return word.toString().toUpperCase();
    }

    /**
     * Returns the array of Letter objects representing individual letters in the word.
     */
    public Letter[] getLetters() {
        return letters;
    }

    /**
     * Checks the provided attempt against the target word and updates the status of individual letters accordingly.
     *
     * @param attempt The Word object representing the attempt to be checked.
     */
    public void checkAttempt(Word attempt) {
        Letter[] wordLetters = attempt.getLetters();
        for (int i = 0; i < letters.length; i++) {
            // In any case it will be absent or more
            if (letters[i].getStatus() == Letter.Status.NONE) {
                letters[i].setStatus(Letter.Status.ABSENT);
            }
            // Compare by elements and change status both target word and attempt word letters
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

    /**
     * Compares the textual representation of the target word to the provided attempt word for equality.
     *
     * @param wordToCompare The attempt word to compare against the target word.
     * @return true if the words are equal, false otherwise.
     */
    public boolean compare(String wordToCompare) {
        return getText().equals(wordToCompare);
    }
}
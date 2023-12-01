package com.chous.wordle;

/**
 * The Letter class represents a single letter in the Wordle game. Each letter has a textual value,
 * and its status indicates whether it is absent, present, or correctly placed in the current context.
 * @value <b>status</b> - The status of the letter (NONE, ABSENT, PRESENT, CORRECT).
 * @value <b>text</b> - The textual value of the letter.
 */
public class Letter {
    private Status status;
    private final String text;

    /**
     * Constructor for the Letter class. Initializes a letter with a specified text.
     * Default status is set to NONE when a letter is created.
     *
     * @param text The textual value of the letter.
     */
    Letter(String text) {
        status = Status.NONE;
        this.text = text;
    }

    /**
     Returns the current status of the letter(NONE, ABSENT, PRESENT, CORRECT).
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Sets the status of the letter to a specified value.
     *
     * @param status The new status to be set for the letter.
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     Returns the textual value of the letter.
     */
    public String getText(){
        return text;
    }

    /**
     * Enumeration representing the possible statuses of a letter.
     * <b>NONE</b> - Initial status when a letter is created.
     * <b>ABSENT</b> - The letter is not present in the current context.
     * <b>PRESENT</b> -The letter is present but not in the correct position.
     * <b>CORRECT</b> - The letter is present and correctly placed in the current context.
     */
    public enum Status {
        NONE, ABSENT, PRESENT, CORRECT
    }
}

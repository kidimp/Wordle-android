package com.chous.wordle;

/**
 * The Game class represents the logic and state management of the Wordle game.
 * It is responsible for handling user interactions, managing the game grid, and controlling game flow.
 */
public class Game {
    Grid grid;
    MainActivity activity;
    private Word word;
    private final DBHandler dbHandler;
    public static final int WORDLE_LENGTH = 5;
    public static final int AMOUNT_OF_ATTEMPTS = 6;

    /**
     * Constructor for the Game class.
     *
     * @param activity The MainActivity instance associated with this game.
     */
    public Game(MainActivity activity) {
        this.activity = activity;

        grid = new Grid(activity);

        dbHandler = DBHandler.getInstance();
    }

    /**
     * Initializes a new game, resetting the game state and generating a new target word.
     */
    public void create() {
        dbHandler.setIsGameFinished(false);
        dbHandler.generateRandomWord();
        word = dbHandler.getWord();
        grid.clean();
        activity.keyboard.clean();
        activity.keyboard.unblockButtons();
    }

    /**
     * Handles a letter button click, adding the clicked letter to the current attempt.
     *
     * @param text The text of the clicked letter button.
     */
    public void ButtonLetterClick(String text) {
        grid.addLetter(text);
    }

    /**
     * Handles the enter button click, validating the current attempt and progressing the game accordingly.
     */
    public void ButtonEnterClick() {
        String attempt = grid.getCurrentAttempt();

        if (!isAttemptValid(attempt)) {
            return;
        }

        grid.apply();

        recolorViews();

        if (word.compare(attempt)) {
            winResult();
            return;
        }

        if (grid.getActiveLineIndex() >= Game.AMOUNT_OF_ATTEMPTS - 1) {
            loseResult();
            return;
        }

        grid.nextLine();
    }

    /**
     * Handles the delete button click, removing the last entered letter from the current attempt.
     */
    public void ButtonDeleteClick() {
        grid.removeLetter();
    }


    /**
     * Displays the statistics dialog and blocks further keyboard interactions.
     */
    private void showStat() {
        activity.keyboard.blockButtons();
        activity.ButtonStatsClick();
    }

    /**
     * Handles the game result when the player wins.
     */
    private void winResult() {
        dbHandler.setIsGameFinished(true);
        dbHandler.setPreviousGameResult(true);

        dbHandler.incrementNumberOfGames();
        dbHandler.incrementNumberOfWins();

        if (dbHandler.getPreviousGameResult()) {
            dbHandler.incrementStreak();
            dbHandler.updateMaxStreak();
        }

        Message.win(grid.getActiveLineIndex());
        showStat();
    }

    /**
     * Handles the game result when the player loses.
     */
    private void loseResult() {
        dbHandler.setIsGameFinished(true);
        dbHandler.setPreviousGameResult(false);

        dbHandler.incrementNumberOfGames();
        dbHandler.resetStreak();

        Message.lose(word.getText());
        showStat();
    }

    /**
     * Checks if a given attempt is valid (is it enough amount of letters and
     * is attempt word exist in database).
     *
     * @param attempt The current attempt to be validated.
     * @return True if the attempt is valid, false otherwise.
     */
    private boolean isAttemptValid(String attempt) {
        if (attempt.length() < Game.WORDLE_LENGTH) {
            Message.notEnoughLetters();
            return false;
        } else {
            if (!dbHandler.isAttemptExist(attempt)) {
                Message.notInWordList();
                return false;
            }
        }
        return true;
    }

    /**
     * Recolors the views within the game grid and keyboard to provide visual feedback.
     */
    private void recolorViews() {
        grid.recolor();
        activity.keyboard.recolorButtons(grid);
    }
}
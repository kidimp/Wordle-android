package com.chous.wordle;

public class Game {
    Grid grid;
    MainActivity activity;
    private Word word;
    private final DBHandler dbHandler;
    public static final int WORDLE_LENGTH = 5;
    public static final int AMOUNT_OF_ATTEMPTS = 6;


    public Game(MainActivity activity) {
        this.activity = activity;

        grid = new Grid(activity);

        dbHandler = DBHandler.getInstance();
    }


    public void create() {
        dbHandler.setIsGameFinished(false);
        dbHandler.generateRandomWord();
        word = dbHandler.getWord();
        grid.clean();
        activity.keyboard.clean();
        activity.keyboard.unblockButtons();
    }


    public void ButtonLetterClick(String text) {
        grid.addLetter(text);
    }


    public void ButtonEnterClick() {
        String attempt = grid.getCurrentAttempt();

        if (!isPossibleAttempt(attempt)) {
            return;
        }

        grid.apply();

        recolorViews();

        if (word.compare(attempt)) {
            winResult();
            return;
        }

        if (grid.getActiveLineIndex() >= Game.AMOUNT_OF_ATTEMPTS -1) {
            loseResult();
            return;
        }

        grid.nextLine();
    }


    public void ButtonDeleteClick() {
        grid.removeLetter();
    }


    private void showStat() {
        activity.keyboard.blockButtons();
        activity.ButtonStatsClick();
    }


    private void winResult() {
        dbHandler.setIsGameFinished(true);
        dbHandler.setPreviousGameResult(true);

        dbHandler.incrementNumberOfGames();
        dbHandler.incrementNumberOfWins();

        if (dbHandler.getPreviousGameResult()){
            dbHandler.incrementStreak();
            dbHandler.updateMaxStreak();
        }

        Message.win(grid.getActiveLineIndex());
        showStat();
    }

    private void loseResult() {
        dbHandler.setIsGameFinished(true);
        dbHandler.setPreviousGameResult(false);

        dbHandler.incrementNumberOfGames();
        dbHandler.resetStreak();

        Message.lose(word.getText());
        showStat();
    }


    private boolean isPossibleAttempt(String attempt) {
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


    private void recolorViews() {
        grid.recolor();
        activity.keyboard.recolorButtons(grid);
    }
}
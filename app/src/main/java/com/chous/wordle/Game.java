package com.chous.wordle;

import android.widget.Button;
import android.widget.ImageButton;

public class Game {
    MainActivity activity;
    private final DBHandler dbHandler;
    public static final int WORDLE_LENGTH = 5;
    public static final int AMOUNT_OF_ATTEMPTS = 6;
    TilesLine[] tilesLines = new TilesLine[AMOUNT_OF_ATTEMPTS];
    Keyboard keyboard;
    int activeLineIndex = 0;
    private ImageButton buttonStats;

    public Game(MainActivity activity) {
        this.activity = activity;

        initViews();

        dbHandler = DBHandler.getInstance();
    }


    public void initViews() {
        tilesLines[0] = new TilesLine(activity.findViewById(R.id.line1));
        tilesLines[1] = new TilesLine(activity.findViewById(R.id.line2));
        tilesLines[2] = new TilesLine(activity.findViewById(R.id.line3));
        tilesLines[3] = new TilesLine(activity.findViewById(R.id.line4));
        tilesLines[4] = new TilesLine(activity.findViewById(R.id.line5));
        tilesLines[5] = new TilesLine(activity.findViewById(R.id.line6));

        keyboard = new Keyboard(activity.findViewById(R.id.linearLayoutButtons));

        buttonStats = activity.findViewById(R.id.button_stats);
    }


    public void create() {
        for (TilesLine tilesLine : tilesLines) {
            tilesLine.clean();
        }

        keyboard.clean();

        for (Button btn : keyboard.getButtonsLetters()) {
            btn.setOnClickListener(v -> ButtonLetterClick(btn));
        }
        keyboard.getButtonEnter().setOnClickListener(v -> ButtonEnterClick());
        keyboard.getButtonDelete().setOnClickListener(v -> ButtonDeleteClick());

        activeLineIndex = 0;

        buttonStats.setOnClickListener(v -> ButtonResultClick());
        Message.setMessageSettings();

        dbHandler.generateRandomWord();
    }


    private void ButtonLetterClick(Button button) {
        tilesLines[activeLineIndex].add((String) button.getText());
    }


    public void ButtonResultClick() {
        DialogResult dialogResult = new DialogResult(activity);
        dialogResult.showDialog("Here will be the statistics");
    }


    private void ButtonEnterClick() {
        String attempt = tilesLines[activeLineIndex].getAttempt();

        if (attempt.length() < 5) {
            Message.notEnoughLetters();
            return;
        } else {
            if (!dbHandler.isAttemptExist(attempt)) {
                Message.notInWordList();
                return;
            }
        }

        tilesLines[activeLineIndex].recolorTiles();
        keyboard.recolorButtons(attempt);

        if (compareAttemptWithWord(attempt)) {
            Message.win(activeLineIndex);
            keyboard.blockButtons();
            ButtonResultClick();
            return;
        }

        activeLineIndex++;

        if (activeLineIndex == 6) {
            Message.lose(dbHandler.getWord());
            keyboard.blockButtons();
            ButtonResultClick();
        }
    }


    private void ButtonDeleteClick() {
        tilesLines[activeLineIndex].remove();
    }


    private boolean compareAttemptWithWord(String attempt) {
        return attempt.equals(dbHandler.getWord());
    }

}

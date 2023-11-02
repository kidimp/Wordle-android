package com.chous.wordle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private DBHandler dbHandler;

    public static final int WORDLE_LENGTH = 5;
    public static final int AMOUNT_OF_ATTEMPTS = 6;

    TilesLine[] tilesLines = new TilesLine[AMOUNT_OF_ATTEMPTS];
    Keyboard keyboard;
    int activeLineIndex = 0;
    private Button buttonResult;


    private void initViews() {
        tilesLines[0] = new TilesLine(findViewById(R.id.line1));
        tilesLines[1] = new TilesLine(findViewById(R.id.line2));
        tilesLines[2] = new TilesLine(findViewById(R.id.line3));
        tilesLines[3] = new TilesLine(findViewById(R.id.line4));
        tilesLines[4] = new TilesLine(findViewById(R.id.line5));
        tilesLines[5] = new TilesLine(findViewById(R.id.line6));

        keyboard = new Keyboard(findViewById(R.id.linearLayoutButtons));

        buttonResult = findViewById(R.id.button_result);
    }


    private void setupViews() {
        for (Button btn : keyboard.getButtonsLetters()) {
            btn.setOnClickListener(v -> ButtonLetterClick(btn));
        }
        keyboard.getButtonEnter().setOnClickListener(v -> ButtonEnterClick());
        keyboard.getButtonDelete().setOnClickListener(v -> ButtonDeleteClick());

        buttonResult.setOnClickListener(v -> ButtonResultClick());
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setupViews();

        dbHandler = DBHandler.getInstance();
        dbHandler.generateRandomWord();

        Message.setMessageSettings();
    }

    private void ButtonLetterClick(Button button) {
        tilesLines[activeLineIndex].add((String) button.getText());
    }

    private void ButtonResultClick() {
        MyDialog myDialog = new MyDialog(MainActivity.this);
        myDialog.showDialog("Say Hello to Me");
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

        activeLineIndex++;

        if (compareAttemptWithWord(attempt)) {
            Message.win(activeLineIndex);
            showResults();
        }

        if (activeLineIndex == 6) {
            Message.lose(dbHandler.getWord());
            showResults();
        }
    }


    private void ButtonDeleteClick() {
        tilesLines[activeLineIndex].remove();
    }


    private boolean compareAttemptWithWord(String attempt) {
        return attempt.equals(dbHandler.getWord());
    }

    public void showResults() {
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        startActivity(intent);
    }


}
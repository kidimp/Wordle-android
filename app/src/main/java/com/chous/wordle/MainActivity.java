package com.chous.wordle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private DBHandler dbHandler;

    public static final int WORDLE_LENGTH = 5;
    public static final int AMOUNT_OF_ATTEMPTS = 6;

    Button[] buttonsLetters = new Button[26];
    Button buttonDelete;
    Button buttonEnter;
    TilesLine[] tilesLines = new TilesLine[AMOUNT_OF_ATTEMPTS];
    int activeLineIndex = 0;


    private void initViews() {
        buttonsLetters[0] = findViewById(R.id.ButtonQ);
        buttonsLetters[1] = findViewById(R.id.ButtonW);
        buttonsLetters[2] = findViewById(R.id.ButtonE);
        buttonsLetters[3] = findViewById(R.id.ButtonR);
        buttonsLetters[4] = findViewById(R.id.ButtonT);
        buttonsLetters[5] = findViewById(R.id.ButtonY);
        buttonsLetters[6] = findViewById(R.id.ButtonU);
        buttonsLetters[7] = findViewById(R.id.ButtonI);
        buttonsLetters[8] = findViewById(R.id.ButtonO);
        buttonsLetters[9] = findViewById(R.id.ButtonP);

        buttonsLetters[10] = findViewById(R.id.ButtonA);
        buttonsLetters[11] = findViewById(R.id.ButtonS);
        buttonsLetters[12] = findViewById(R.id.ButtonD);
        buttonsLetters[13] = findViewById(R.id.ButtonF);
        buttonsLetters[14] = findViewById(R.id.ButtonG);
        buttonsLetters[15] = findViewById(R.id.ButtonH);
        buttonsLetters[16] = findViewById(R.id.ButtonJ);
        buttonsLetters[17] = findViewById(R.id.ButtonK);
        buttonsLetters[18] = findViewById(R.id.ButtonL);

        buttonsLetters[19] = findViewById(R.id.ButtonZ);
        buttonsLetters[20] = findViewById(R.id.ButtonX);
        buttonsLetters[21] = findViewById(R.id.ButtonC);
        buttonsLetters[22] = findViewById(R.id.ButtonV);
        buttonsLetters[23] = findViewById(R.id.ButtonB);
        buttonsLetters[24] = findViewById(R.id.ButtonN);
        buttonsLetters[25] = findViewById(R.id.ButtonM);

        buttonEnter = findViewById(R.id.ButtonEnter);
        buttonDelete = findViewById(R.id.ButtonDelete);

        tilesLines[0] = new TilesLine(findViewById(R.id.line1));
        tilesLines[1] = new TilesLine(findViewById(R.id.line2));
        tilesLines[2] = new TilesLine(findViewById(R.id.line3));
        tilesLines[3] = new TilesLine(findViewById(R.id.line4));
        tilesLines[4] = new TilesLine(findViewById(R.id.line5));
        tilesLines[5] = new TilesLine(findViewById(R.id.line6));
    }


    private void setupViews() {
        for (Button btn : buttonsLetters) {
            btn.setOnClickListener(v -> ButtonLetterClick(btn));
        }
        buttonEnter.setOnClickListener(v -> ButtonEnterClick());
        buttonDelete.setOnClickListener(v -> ButtonDeleteClick());
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

        tilesLines[activeLineIndex].recolor();

        if (compareAttemptWithWord(attempt)) {
            Message.win(activeLineIndex);
        }

        activeLineIndex++;
    }


    private void ButtonDeleteClick() {
        tilesLines[activeLineIndex].remove();
    }


    private boolean compareAttemptWithWord(String attempt) {
        return attempt.equals(dbHandler.getWord());
    }

}
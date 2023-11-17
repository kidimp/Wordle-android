package com.chous.wordle;

import android.widget.Button;
import android.widget.LinearLayout;

import androidx.core.content.res.ResourcesCompat;

public class Keyboard {
    private final Button[] buttonsLetters = new Button[26];
    private final Button buttonDelete;
    private final Button buttonEnter;

    public Keyboard(LinearLayout layout) {
        int[] buttonId = {R.id.ButtonQ, R.id.ButtonW, R.id.ButtonE, R.id.ButtonR, R.id.ButtonT,
                R.id.ButtonY, R.id.ButtonU, R.id.ButtonI, R.id.ButtonO, R.id.ButtonP, R.id.ButtonA,
                R.id.ButtonS, R.id.ButtonD, R.id.ButtonF, R.id.ButtonG, R.id.ButtonH, R.id.ButtonJ,
                R.id.ButtonK, R.id.ButtonL, R.id.ButtonZ, R.id.ButtonX, R.id.ButtonC, R.id.ButtonV,
                R.id.ButtonB, R.id.ButtonN, R.id.ButtonM};
        for (int i = 0; i < buttonsLetters.length && i < buttonId.length; i++) {
            buttonsLetters[i] = layout.findViewById(buttonId[i]);
        }

        buttonEnter = layout.findViewById(R.id.ButtonEnter);
        buttonDelete = layout.findViewById(R.id.ButtonDelete);
    }

    public void setup(Game game) {
        for (Button btn : buttonsLetters) {
            btn.setOnClickListener(v -> game.ButtonLetterClick((String) btn.getText()));
        }
        buttonEnter.setOnClickListener(v -> game.ButtonEnterClick());
        buttonDelete.setOnClickListener(v -> game.ButtonDeleteClick());
    }

    private Button getLetterButton(String text) {
        for (Button btn : buttonsLetters) {
            if (btn.getText().equals(text)) {
                return btn;
            }
        }
        return null;
    }

    public void recolorButtons(Grid grid) {
        TilesLine[] tilesLines = grid.getTilesLines();
        TilesLine currentTilesLine = tilesLines[grid.getActiveLineIndex()];
        Word attempt = currentTilesLine.getAttempt();

        for (Letter letter : attempt.getLetters()) {
            recolor(letter);
        }

        for (Letter letter : DBHandler.getInstance().getWord().getLetters()) {
            recolor(letter);
        }
    }

    private void recolor(Letter letter){
        Button btn = getLetterButton(letter.getText());

        if (btn == null) {
            return;
        }

        switch (letter.getStatus()) {
            case ABSENT: {
                btn.setBackground(ResourcesCompat.getDrawable(btn.getContext().getResources(),
                        R.drawable.button_gray_dark, null));
                break;
            }
            case PRESENT: {
                btn.setBackground(ResourcesCompat.getDrawable(btn.getContext().getResources(),
                        R.drawable.button_yellow, null));
                break;
            }
            case CORRECT: {
                btn.setBackground(ResourcesCompat.getDrawable(btn.getContext().getResources(),
                        R.drawable.button_green, null));
                break;
            }
        }
    }

    public void blockButtons() {
        for (Button button : buttonsLetters) {
            button.setEnabled(false);
        }
        buttonEnter.setEnabled(false);
        buttonDelete.setEnabled(false);
    }

    public void unblockButtons() {
        for (Button button : buttonsLetters) {
            button.setEnabled(true);
        }
        buttonEnter.setEnabled(true);
        buttonDelete.setEnabled(true);
    }

    public void clean() {
        for (Button button : buttonsLetters) {
            button.setBackground(ResourcesCompat.getDrawable(button.getContext().getResources(),
                    R.drawable.button_gray_light, null));
        }
    }
}
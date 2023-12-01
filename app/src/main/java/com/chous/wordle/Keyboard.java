package com.chous.wordle;

import android.widget.Button;
import android.widget.LinearLayout;

import androidx.core.content.res.ResourcesCompat;

/**
 * The Keyboard class represents the on-screen keyboard in the Wordle game,
 * providing buttons for letters, enter, and delete actions. It handles user interactions
 * with the keyboard, such as letter clicks, enter button clicks, and delete button clicks.
 * The class also manages the visual appearance of the keyboard buttons based on game-related information.
 */
public class Keyboard {
    private final Button[] buttonsLetters = new Button[26];
    private final Button buttonDelete;
    private final Button buttonEnter;

    /**
     * Constructor for the Keyboard class. Here we Initialize letter buttons based on their XML layout IDs
     * and initialize enter and delete buttons based on their XML layout IDs.
     *
     * @param layout The LinearLayout containing the keyboard buttons.
     */
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

    /**
     * Sets up click listeners for each letter, enter, and delete button in the keyboard,
     * linking them to the corresponding actions in the provided Game instance.
     *
     * @param game The Game instance associated with the keyboard.
     */
    public void setup(Game game) {
        for (Button btn : buttonsLetters) {
            btn.setOnClickListener(v -> game.ButtonLetterClick((String) btn.getText()));
        }
        buttonEnter.setOnClickListener(v -> game.ButtonEnterClick());
        buttonDelete.setOnClickListener(v -> game.ButtonDeleteClick());
    }

    /**
     * Retrieves the letter button associated with a specific letter.
     *
     * @param text The text of the letter.
     * @return The Button object associated with the letter, or null if not found.
     */
    private Button getLetterButton(String text) {
        for (Button btn : buttonsLetters) {
            if (btn.getText().equals(text)) {
                return btn;
            }
        }
        return null;
    }

    /**
     * Recolors the letter buttons. If at the next attempt the already guessed letter (green) is out of place,
     * it will become yellow (which is incorrect). Therefore, we recolor the letters of the attempt first,
     * and then the letters of the target word. See also {@link com.chous.wordle.Word#checkAttempt(Word word)}
     *
     * @param grid The Grid instance representing the game grid.
     */
    public void recolorButtons(Grid grid) {
        recolorAttemptButtons(grid);
        recolorWordButtons();
    }

    /**
     * Recolors the letter buttons based on the correctness of the attempt.
     *
     * @param grid The Grid instance representing the game grid.
     */
    public void recolorAttemptButtons(Grid grid) {
        TilesLine[] tilesLines = grid.getTilesLines();
        TilesLine currentTilesLine = tilesLines[grid.getActiveLineIndex()];
        Word attempt = currentTilesLine.getAttempt();

        for (Letter letter : attempt.getLetters()) {
            recolor(letter);
        }
    }

    /**
     * Recolors the letter buttons based on the correctness of the letters in the target word.
     */
    public void recolorWordButtons() {
        for (Letter letter : DBHandler.getInstance().getWord().getLetters()) {
            recolor(letter);
        }
    }

    /**
     * Recolors a specific letter button based on the correctness of the letter in the current context.
     *
     * @param letter The Letter instance associated with the button.
     */
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

    /**
     * Disables all letter, enter, and delete buttons in the keyboard.
     * Used to prevent further user interactions when the game is over.
     */
    public void blockButtons() {
        for (Button button : buttonsLetters) {
            button.setEnabled(false);
        }
        buttonEnter.setEnabled(false);
        buttonDelete.setEnabled(false);
    }

    /**
     * Enables all letter, enter, and delete buttons in the keyboard.
     * Used to allow user start a new game.
     */
    public void unblockButtons() {
        for (Button button : buttonsLetters) {
            button.setEnabled(true);
        }
        buttonEnter.setEnabled(true);
        buttonDelete.setEnabled(true);
    }

    /**
     * Resets the background of all letter buttons to the default light gray color.
     */
    public void clean() {
        for (Button button : buttonsLetters) {
            button.setBackground(ResourcesCompat.getDrawable(button.getContext().getResources(),
                    R.drawable.button_gray_light, null));
        }
    }
}
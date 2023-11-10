package com.chous.wordle;

import android.widget.Button;
import android.widget.LinearLayout;

import androidx.core.content.res.ResourcesCompat;

public class Keyboard {
    private final Button[] buttonsLetters = new Button[26];
    private final Button buttonDelete;
    private final Button buttonEnter;

    public Keyboard(LinearLayout layout) {
        buttonsLetters[0] = layout.findViewById(R.id.ButtonQ);
        buttonsLetters[1] = layout.findViewById(R.id.ButtonW);
        buttonsLetters[2] = layout.findViewById(R.id.ButtonE);
        buttonsLetters[3] = layout.findViewById(R.id.ButtonR);
        buttonsLetters[4] = layout.findViewById(R.id.ButtonT);
        buttonsLetters[5] = layout.findViewById(R.id.ButtonY);
        buttonsLetters[6] = layout.findViewById(R.id.ButtonU);
        buttonsLetters[7] = layout.findViewById(R.id.ButtonI);
        buttonsLetters[8] = layout.findViewById(R.id.ButtonO);
        buttonsLetters[9] = layout.findViewById(R.id.ButtonP);

        buttonsLetters[10] = layout.findViewById(R.id.ButtonA);
        buttonsLetters[11] = layout.findViewById(R.id.ButtonS);
        buttonsLetters[12] = layout.findViewById(R.id.ButtonD);
        buttonsLetters[13] = layout.findViewById(R.id.ButtonF);
        buttonsLetters[14] = layout.findViewById(R.id.ButtonG);
        buttonsLetters[15] = layout.findViewById(R.id.ButtonH);
        buttonsLetters[16] = layout.findViewById(R.id.ButtonJ);
        buttonsLetters[17] = layout.findViewById(R.id.ButtonK);
        buttonsLetters[18] = layout.findViewById(R.id.ButtonL);

        buttonsLetters[19] = layout.findViewById(R.id.ButtonZ);
        buttonsLetters[20] = layout.findViewById(R.id.ButtonX);
        buttonsLetters[21] = layout.findViewById(R.id.ButtonC);
        buttonsLetters[22] = layout.findViewById(R.id.ButtonV);
        buttonsLetters[23] = layout.findViewById(R.id.ButtonB);
        buttonsLetters[24] = layout.findViewById(R.id.ButtonN);
        buttonsLetters[25] = layout.findViewById(R.id.ButtonM);

        buttonEnter = layout.findViewById(R.id.ButtonEnter);
        buttonDelete = layout.findViewById(R.id.ButtonDelete);
    }

    public Button[] getButtonsLetters() {
        return buttonsLetters;
    }

    public Button getButtonEnter() {
        return buttonEnter;
    }

    public Button getButtonDelete() {
        return buttonDelete;
    }

    public void recolorButtons(String attempt) {
        String word = DBHandler.getInstance().getWord();

        for (int i = 0; i < attempt.length(); i++) {
            int index = -1;
            for (int j = 0; j < buttonsLetters.length; j++) {
                if (buttonsLetters[j].getText().equals(attempt.substring(i, i + 1))) {
                    index = j;
                }
            }

            if (word.contains(attempt.substring(i, i + 1))) {
                buttonsLetters[index].setBackground(ResourcesCompat.getDrawable(buttonsLetters[index].getContext().getResources(),
                        R.drawable.button_yellow, null));
            } else {
                buttonsLetters[index].setBackground(ResourcesCompat.getDrawable(buttonsLetters[index].getContext().getResources(),
                        R.drawable.button_gray_dark, null));
            }
            if ((word.substring(i, i + 1)).equals(attempt.substring(i, i + 1))) {
                buttonsLetters[index].setBackground(ResourcesCompat.getDrawable(buttonsLetters[index].getContext().getResources(),
                        R.drawable.button_green, null));
            }
        }
    }

    public void blockButtons() {
        for (Button buttonLetter : buttonsLetters) {
            buttonLetter.setOnClickListener(null);
        }
        buttonEnter.setOnClickListener(null);
        buttonDelete.setOnClickListener(null);
    }

    public void clean() {
        for (Button button : buttonsLetters) {
            button.setBackground(ResourcesCompat.getDrawable(button.getContext().getResources(),
                    R.drawable.button_gray_light, null));
        }
    }
}
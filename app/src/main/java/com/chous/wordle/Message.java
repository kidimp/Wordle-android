package com.chous.wordle;

import android.view.Gravity;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public class Message {
    static String[] message = {"Genius", "Magnificent", "Impressive", "Splendid", "Great", "Phew"};

    public static void setMessageSettings() {
        Toasty.Config.getInstance()
                .setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 300).apply();
    }

    public static void win(int tryIndex) {
        Toasty.normal(App.getContext(), message[tryIndex], Toast.LENGTH_SHORT).show();
    }

    public static void notInWordList() {
        Toasty.normal(App.getContext(), "Not in word list", Toast.LENGTH_SHORT).show();
    }

    public static void notEnoughLetters() {
        Toasty.normal(App.getContext(), "Not enough letters", Toast.LENGTH_SHORT).show();
    }
}

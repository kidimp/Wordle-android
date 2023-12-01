package com.chous.wordle;

import android.view.Gravity;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

/**
 * The Message class is responsible for displaying various messages and toasts in the Wordle game application.
 * It provides methods for showing win messages, lose messages, and notifications for specific scenarios.
 * @value <b>message</b> - Array of positive messages displayed on winning attempts.
 */
public class Message {
    static String[] message = {"Genius", "Magnificent", "Impressive", "Splendid", "Great", "Phew"};

    /**
     * Sets up the configuration for displaying toasts using the Toasty library.
     * Configures the gravity and position of the toasts.
     */
    public static void setMessageSettings() {
        Toasty.Config.getInstance()
                .setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 300).apply();
    }

    /**
     * Displays a normal toast with a positive message based on the attempt index.
     *
     * @param tryIndex The index representing the attempt.
     */
    public static void win(int tryIndex) {
        Toasty.normal(App.getContext(), message[tryIndex], Toast.LENGTH_SHORT).show();
    }

    /**
     * Displays a normal toast with the provided word in case of a loss.
     * It is shows target word after loss.
     *
     * @param word The word that was not guessed correctly.
     */
    public static void lose(String word) {
        Toasty.normal(App.getContext(), word, Toast.LENGTH_LONG).show();
    }

    /**
     * Displays a normal toast indicating that the attempted word is not in the word list.
     */
    public static void notInWordList() {
        Toasty.normal(App.getContext(), "Not in word list", Toast.LENGTH_SHORT).show();
    }

    /**
     * Displays a normal toast indicating that there are not enough letters in the attempted word.
     */
    public static void notEnoughLetters() {
        Toasty.normal(App.getContext(), "Not enough letters", Toast.LENGTH_SHORT).show();
    }
}

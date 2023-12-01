package com.chous.wordle;

import android.app.Dialog;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * DialogStats class represents a custom dialog displaying statistics related to the Wordle game.
 * It includes information such as the number of played games, the percentage of wins, the current streak,
 * and the maximum streak achieved. The dialog is designed to be used in the context of the MainActivity.
 */
public class DialogStats {
    // Reference to the MainActivity instance
    MainActivity activity;

    // Dialog instance for displaying the statistics
    Dialog dialog;

    // Views within the custom dialog
    TextView txt_message;
    TextView numberOfPlayedGames;
    TextView percentOfWins;
    TextView streak;
    TextView maxStreak;
    ImageButton buttonCloseDialog;
    Button buttonNewGame;

    // Instance of the DBHandler for database operations
    private final DBHandler dbHandler;

    /**
     * Constructor for the DialogStats class.
     *
     * @param activity The MainActivity instance to which this dialog is associated.
     */
    public DialogStats(MainActivity activity) {
        dbHandler = DBHandler.getInstance();
        this.activity = activity;

        dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_stats);

        innitViews();

        setupDialogView();
    }

    /**
     * Initializes views within the custom dialog.
     */
    private void innitViews() {
        txt_message = dialog.findViewById(R.id.statistics1);

        numberOfPlayedGames = dialog.findViewById(R.id.played);
        percentOfWins = dialog.findViewById(R.id.wins_persentage);
        streak = dialog.findViewById(R.id.current_streak);
        maxStreak = dialog.findViewById(R.id.max_streak);

        buttonCloseDialog = dialog.findViewById(R.id.button_close_dialog);
        buttonNewGame = dialog.findViewById(R.id.button_new_game);
    }

    /**
     * Sets up event listeners for buttons and other interactive elements within the dialog.
     */
    private void setupDialogView() {
        buttonCloseDialog.setOnClickListener(v -> buttonCloseDialogClick());
        buttonNewGame.setOnClickListener(v -> buttonNewGameClick());
    }

    /**
     * Displays the statistics dialog.
     */
    public void showDialog() {
        dialog.show();
    }

    /**
     * Handles the click event for the close button, dismissing the dialog.
     */
    private void buttonCloseDialogClick() {
        try {
            dialog.dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles the click event for the new game button. Increments the number of games if the current game
     * was not finished, creates a new game, and dismisses the dialog.
     */
    private void buttonNewGameClick() {
        if (!dbHandler.getIsGameFinished()){
            dbHandler.incrementNumberOfGames();
        }
        activity.getGame().create();
        buttonCloseDialogClick();
    }

    /**
     * Updates the views within the statistics dialog with the latest statistics from the database.
     */
    public void updateStatsView() {
        int numberOfGames = dbHandler.getNumberOfGames();
        int numberOfWins = dbHandler.getNumberOfWins();
        double winningPercent = (numberOfGames > 0) ? ((double) numberOfWins / numberOfGames) * 100 : 0.0;
        int currentStreak = dbHandler.getStreak();
        int max_streak = dbHandler.getMaxStreak();

        numberOfPlayedGames.setText(String.valueOf(numberOfGames));
        percentOfWins.setText(String.valueOf((int) winningPercent));
        streak.setText(String.valueOf(currentStreak));
        maxStreak.setText(String.valueOf(max_streak));
    }
}
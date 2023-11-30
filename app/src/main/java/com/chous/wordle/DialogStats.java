package com.chous.wordle;

import android.app.Dialog;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class DialogStats {
    MainActivity activity;
    TextView txt_message;
    TextView numberOfPlayedGames;
    TextView percentOfWins;
    TextView streak;
    TextView maxStreak;
    ImageButton buttonCloseDialog;
    Button buttonNewGame;
    Dialog dialog;
    private final DBHandler dbHandler;

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

    private void innitViews() {
        txt_message = dialog.findViewById(R.id.statistics1);

        numberOfPlayedGames = dialog.findViewById(R.id.played);
        percentOfWins = dialog.findViewById(R.id.wins_persentage);
        streak = dialog.findViewById(R.id.current_streak);
        maxStreak = dialog.findViewById(R.id.max_streak);

        buttonCloseDialog = dialog.findViewById(R.id.button_close_dialog);
        buttonNewGame = dialog.findViewById(R.id.button_new_game);
    }

    private void setupDialogView() {
        buttonCloseDialog.setOnClickListener(v -> buttonCloseDialogClick());
        buttonNewGame.setOnClickListener(v -> buttonNewGameClick());
    }

    public void showDialog() {
        dialog.show();
    }

    private void buttonCloseDialogClick() {
        try {
            dialog.dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void buttonNewGameClick() {
        if (!dbHandler.getIsGameFinished()){
            dbHandler.incrementNumberOfGames();
        }
        activity.getGame().create();
        buttonCloseDialogClick();
    }


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
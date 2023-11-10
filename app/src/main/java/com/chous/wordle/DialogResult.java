package com.chous.wordle;

import android.app.Dialog;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class DialogResult {
    MainActivity activity;
    TextView txt_Message;
    ImageButton buttonCloseDialog;
    Button buttonNewGame;
    Dialog dialog;

    public DialogResult(MainActivity activity) {
        this.activity = activity;
        dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_stats);
        txt_Message = dialog.findViewById(R.id.statistics);

        buttonCloseDialog = dialog.findViewById(R.id.button_close_dialog);
        buttonNewGame = dialog.findViewById(R.id.button_new_game);

        setupDialogView();
    }

    private void setupDialogView() {
        buttonCloseDialog.setOnClickListener(v -> buttonCloseDialogClick());
        buttonNewGame.setOnClickListener(v -> buttonNewGameClick());
    }

    public void showDialog(String message) {
        txt_Message.setText(message);
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
        activity.getGame().create();
        buttonCloseDialogClick();
    }
}
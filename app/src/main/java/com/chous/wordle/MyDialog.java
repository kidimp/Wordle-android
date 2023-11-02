package com.chous.wordle;
import android.app.Activity;
import android.app.Dialog;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MyDialog {

    Activity activity;
    TextView txt_Message;
    Button buttonCloseDialog;
//    Button buttonNewGame;
    Dialog dialog;

    public MyDialog(Activity activity) {
        this.activity = activity;
        dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.my_dialog);
        txt_Message = dialog.findViewById(R.id.my_dialog);

        buttonCloseDialog = dialog.findViewById(R.id.button_close_dialog);
//        buttonNewGame = dialog.findViewById(R.id.button_new_game);

        setupDialogView();
    }

    private void setupDialogView() {
        buttonCloseDialog.setOnClickListener(v -> buttonCloseDialogClick());
//        buttonNewGame.setOnClickListener(v -> newGame());
    }

    public void showDialog(String message) {



        txt_Message.setText(message);

        dialog.show();
    }

    public void buttonCloseDialogClick() {
        try {
            dialog.dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Button getButtonCloseDialog() {
        return buttonCloseDialog;
    }
}
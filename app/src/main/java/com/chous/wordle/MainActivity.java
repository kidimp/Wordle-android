package com.chous.wordle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private Game game;
    public Keyboard keyboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        game = new Game(this);
        keyboard = new Keyboard(findViewById(R.id.linearLayoutButtons));
        keyboard.setup(game);
        setupViews();

        game.create();
    }


    public Game getGame() {
        return game;
    }


    private void setupViews() {
        Message.setMessageSettings();
        ImageButton buttonStats = findViewById(R.id.button_stats);
        buttonStats.setOnClickListener(v -> ButtonStatsClick());
    }


    public void ButtonStatsClick() {
        DialogStats dialogStats = new DialogStats(this);
        dialogStats.updateStatsView();
        dialogStats.showDialog();
    }
}
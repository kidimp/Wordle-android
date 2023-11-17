package com.chous.wordle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private Game game;
    Keyboard keyboard;
    private ImageButton buttonStats;

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

    public Game getGame() { return game; }

    private void setupViews() {
        Message.setMessageSettings();
        buttonStats = findViewById(R.id.button_stats);
        buttonStats.setOnClickListener(v -> ButtonResultClick());
    }

    public void ButtonResultClick() {
        DialogStats dialogStats = new DialogStats(this);
        dialogStats.showDialog("Here will be the statistics");
    }
}
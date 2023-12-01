package com.chous.wordle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;

/**
 * The MainActivity class serves as the main entry point for the Wordle game application.
 * It extends the AppCompatActivity and is responsible for setting up the game, handling user interactions,
 * and managing the lifecycle of the application's main activity.
 * @value <b>game</b> - representing the current game session.
 * @value <b>keyboard</b> - representing the on-screen keyboard.
 */
public class MainActivity extends AppCompatActivity {
    private Game game;
    public Keyboard keyboard;

    /**
     * Called when the activity is first created. Initializes the game, keyboard, and views.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down,
     *                           this Bundle contains the data it most recently supplied in onSaveInstanceState(Bundle).
     */
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

    /**
     * Returns the current Game instance associated with the MainActivity.
     */
    public Game getGame() {
        return game;
    }

    /**
     * Sets up the views, including the message settings and click listener for the stats button.
     */
    private void setupViews() {
        Message.setMessageSettings();
        ImageButton buttonStats = findViewById(R.id.button_stats);
        buttonStats.setOnClickListener(v -> ButtonStatsClick());
    }

    /**
     * Handles the click event for the stats button by displaying the stats dialog.
     */
    public void ButtonStatsClick() {
        DialogStats dialogStats = new DialogStats(this);
        dialogStats.updateStatsView();
        dialogStats.showDialog();
    }
}
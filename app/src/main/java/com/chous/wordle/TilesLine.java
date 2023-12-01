package com.chous.wordle;

import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.res.ResourcesCompat;

/**
 * The TilesLine class represents a line of tiles in the Wordle game, where each tile corresponds to a letter in an attempt.
 * It is responsible for managing the visual representation of the attempt, including adding letters, removing letters, and applying the attempt.
 * @value <b>attempt</b> - The Word object representing the current attempt.
 * @value <b>tiles</b> - Array of TextViews representing individual tiles in the line.
 */
public class TilesLine {
    Word attempt;
    TextView[] tiles;

    /**
     * Constructor for the TilesLine class. Initializes the array of TextViews corresponding to tiles in the line.
     *
     * @param layout The LinearLayout containing the TextViews representing tiles.
     */
    public TilesLine(LinearLayout layout) {
        tiles = new TextView[Game.WORDLE_LENGTH];
        tiles[0] = layout.findViewById(R.id.Tile1);
        tiles[1] = layout.findViewById(R.id.Tile2);
        tiles[2] = layout.findViewById(R.id.Tile3);
        tiles[3] = layout.findViewById(R.id.Tile4);
        tiles[4] = layout.findViewById(R.id.Tile5);
    }

    /**
     * Adds a letter to the next available tile in the line.
     *
     * @param letter The letter to be added to the line.
     */
    public void add(String letter) {
        TextView activeTile = getActiveTile();
        if (activeTile != null) {
            activeTile.setText(letter);
        }
    }

    /**
     * Removes the last entered letter in the line.
     */
    public void remove() {
        for (int i = Game.WORDLE_LENGTH - 1; i >= 0; i--) {
            if (!tiles[i].getText().equals("")) {
                tiles[i].setText("");
                break;
            }
        }
    }

    /**
     * Retrieves the next available tile in the line.
     *
     * @return The TextView representing the next available tile.
     */
    private TextView getActiveTile() {
        for (TextView tile : tiles) {
            if (tile.getText().equals("")) {
                return tile;
            }
        }
        return null;
    }

    /**
     * Applies the current attempt by creating a Word object and checking it against the target word.<br>
     * See also {@link com.chous.wordle.Word#checkAttempt(Word word)}
     */
    public void applyAttempt() {
        attempt = new Word(constructAttempt());
        attempt.checkAttempt(DBHandler.getInstance().getWord());
    }

    /**
     * Constructs the current attempt by concatenating the letters in the line.
     *
     * @return The textual representation of the current attempt.
     */
    public String constructAttempt() {
        StringBuilder attempt = new StringBuilder();
        for (TextView tile : tiles) {
            attempt.append(tile.getText());
        }
        return attempt.toString().toUpperCase();
    }

    /**
     * Returns the Word object representing the current attempt.
     */
    public Word getAttempt(){
        return attempt;
    }

    /**
     * Recolors the tiles based on the status of the corresponding letters in the attempt.
     */
    public void recolorTiles() {
        Letter[] letters = attempt.getLetters();
        for (int i = 0; i < letters.length; i++) {
            switch (letters[i].getStatus()) {
                case NONE: {
                    tiles[i].setBackground(ResourcesCompat.getDrawable(tiles[i].getContext().getResources(),
                            R.drawable.tile_empty, null));
                    break;
                }
                case ABSENT: {
                    tiles[i].setBackground(ResourcesCompat.getDrawable(tiles[i].getContext().getResources(),
                            R.drawable.tile_gray_dark, null));
                    break;
                }
                case PRESENT: {
                    tiles[i].setBackground(ResourcesCompat.getDrawable(tiles[i].getContext().getResources(),
                            R.drawable.tile_yellow, null));
                    break;
                }
                case CORRECT: {
                    tiles[i].setBackground(ResourcesCompat.getDrawable(tiles[i].getContext().getResources(),
                            R.drawable.tile_green, null));
                    break;
                }
            }
        }
    }

    /**
     * Resets the state of the tiles, clearing the attempt and setting them to the default appearance.
     */
    public void clean() {
        for (TextView textView : tiles) {
            attempt = null;
            textView.setText("");
            textView.setBackground(ResourcesCompat.getDrawable(textView.getContext().getResources(),
                    R.drawable.tile_empty, null));
        }
    }
}

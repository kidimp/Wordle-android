package com.chous.wordle;

import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.res.ResourcesCompat;

public class TilesLine {
    Word attempt;
    TextView[] tiles;


    public TilesLine(LinearLayout layout) {
        tiles = new TextView[Game.WORDLE_LENGTH];
        tiles[0] = layout.findViewById(R.id.Tile1);
        tiles[1] = layout.findViewById(R.id.Tile2);
        tiles[2] = layout.findViewById(R.id.Tile3);
        tiles[3] = layout.findViewById(R.id.Tile4);
        tiles[4] = layout.findViewById(R.id.Tile5);
    }


    public void add(String letter) {
        TextView activeTile = getActiveTile();
        if (activeTile != null) {
            activeTile.setText(letter);
        }
    }


    public void remove() {
        for (int i = Game.WORDLE_LENGTH - 1; i >= 0; i--) {
            if (!tiles[i].getText().equals("")) {
                tiles[i].setText("");
                break;
            }
        }
    }


    private TextView getActiveTile() {
        for (TextView tile : tiles) {
            if (tile.getText().equals("")) {
                return tile;
            }
        }
        return null;
    }


    public void applyAttempt() {
        attempt = new Word(constructAttempt());
        attempt.checkAttempt(DBHandler.getInstance().getWord());
    }

    public String constructAttempt() {
        StringBuilder attempt = new StringBuilder();
        for (TextView tile : tiles) {
            attempt.append(tile.getText());
        }
        return attempt.toString().toUpperCase();
    }

    public Word getAttempt(){
        return attempt;
    }


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


    public void clean() {
        for (TextView textView : tiles) {
            attempt = null;
            textView.setText("");
            textView.setBackground(ResourcesCompat.getDrawable(textView.getContext().getResources(),
                    R.drawable.tile_empty, null));
        }
    }
}

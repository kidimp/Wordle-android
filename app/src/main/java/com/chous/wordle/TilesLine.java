package com.chous.wordle;

import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.res.ResourcesCompat;

public class TilesLine {
    TextView[] tiles;

    public TilesLine(LinearLayout layout) {
        tiles = new TextView[MainActivity.WORDLE_LENGTH];
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
        for (int i = MainActivity.WORDLE_LENGTH - 1; i >= 0; i--) {
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


    public String getAttempt() {
        StringBuilder attempt = new StringBuilder();
        for (TextView tile : tiles) {
            attempt.append(tile.getText());
        }
        return attempt.toString().toUpperCase();
    }

    public void recolorTiles() {
        String attempt = getAttempt();
        String word = DBHandler.getInstance().getWord();

        for (int i = 0; i < attempt.length(); i++) {
            int index = word.indexOf(attempt.substring(i, i + 1));
            if (index >= 0) {
                if (index == i) {
                    tiles[i].setBackground(ResourcesCompat.getDrawable(tiles[i].getContext().getResources(),
                            R.drawable.tile_green, null));
                } else {
                    tiles[i].setBackground(ResourcesCompat.getDrawable(tiles[i].getContext().getResources(),
                            R.drawable.tile_yellow, null));
                }
            } else {
                tiles[i].setBackground(ResourcesCompat.getDrawable(tiles[i].getContext().getResources(),
                        R.drawable.tile_gray_dark, null));
            }
        }
    }
}
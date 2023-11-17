package com.chous.wordle;

import android.app.Activity;

public class Grid {
    private int activeLineIndex;
    private TilesLine[] tilesLines;

    Grid(Activity activity) {
        activeLineIndex = 0;
        tilesLines = new TilesLine[Game.AMOUNT_OF_ATTEMPTS];
        initViews(activity);
    }

    private void initViews(Activity activity) {
        int[] lineId = {R.id.line1, R.id.line2, R.id.line3,
                R.id.line4, R.id.line5, R.id.line6};
        for (int i = 0; i < tilesLines.length && i < lineId.length; i++) {
            tilesLines[i] = new TilesLine(activity.findViewById(lineId[i]));
        }
    }

    public TilesLine[] getTilesLines(){
        return tilesLines;
    }

    public void addLetter(String letter) {
        tilesLines[activeLineIndex].add(letter);
    }

    public void removeLetter() {
        tilesLines[activeLineIndex].remove();
    }

    public void apply() {
        tilesLines[activeLineIndex].applyAttempt();
    }


    public String getCurrentAttempt() {
        return tilesLines[activeLineIndex].constructAttempt();
    }

    public void recolor() {
        for (int i = 0; i < tilesLines.length; i++) {
            if (tilesLines[i].attempt != null) {
                tilesLines[i].recolorTiles();
            }
        }
    }

    public int getActiveLineIndex() {
        return activeLineIndex;
    }

    public void nextLine() {
        if (++activeLineIndex > Game.AMOUNT_OF_ATTEMPTS) {
            activeLineIndex = Game.AMOUNT_OF_ATTEMPTS;
        }
    }

    public void clean() {
        for (TilesLine line : tilesLines) {
            line.clean();
        }
        activeLineIndex = 0;
    }
}

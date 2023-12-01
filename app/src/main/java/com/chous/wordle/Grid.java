package com.chous.wordle;

import android.app.Activity;

/**
 * The Grid class represents the game grid in the Wordle game, consisting of 6 lines for attempts.
 * It manages user input, displays attempts, and provides methods to interact with and manipulate the grid.
 * @value <b>activeLineIndex</b> - Index of the currently active line in the grid private int activeLineIndex;
 * @value <b>tilesLines</b> - Array of TilesLine objects representing each line in the grid
 */
public class Grid {
    private int activeLineIndex;
    private final TilesLine[] tilesLines;

    /**
     * Constructor for the Grid class. We initialize the active line index to the first line,
     * initialize the array of TilesLine objects based on the number of attempts allowed and
     * initialize views for each line in the grid
     *
     * @param activity The Activity instance associated with the grid (Main Activity).
     */
    Grid(Activity activity) {
        activeLineIndex = 0;
        tilesLines = new TilesLine[Game.AMOUNT_OF_ATTEMPTS];
        initViews(activity);
    }

    /**
     * Initializes the views for each line in the grid based on their respective XML layout IDs.
     *
     * @param activity The Activity instance associated with the grid (Main Activity).
     */
    private void initViews(Activity activity) {
        int[] lineId = {R.id.line1, R.id.line2, R.id.line3,
                R.id.line4, R.id.line5, R.id.line6};
        for (int i = 0; i < tilesLines.length && i < lineId.length; i++) {
            tilesLines[i] = new TilesLine(activity.findViewById(lineId[i]));
        }
    }

    /**
     * Returns an array of TilesLine objects representing each line in the grid.
     */
    public TilesLine[] getTilesLines(){
        return tilesLines;
    }

    /**
     * Adds a letter to the currently active line in the grid.
     *
     * @param letter The letter to be added.
     */
    public void addLetter(String letter) {
        tilesLines[activeLineIndex].add(letter);
    }

    /**
     * Removes the last entered letter from the currently active line in the grid.
     */
    public void removeLetter() {
        tilesLines[activeLineIndex].remove();
    }

    /**
     * Applies the current attempt on the active line in the grid.
     */
    public void apply() {
        tilesLines[activeLineIndex].applyAttempt();
    }

    /**
     * Constructs and returns the current attempt on the active line as a string.
     */
    public String getCurrentAttempt() {
        return tilesLines[activeLineIndex].constructAttempt();
    }

    /**
     * Recolors the tiles in each line of the grid based on the correctness of the attempts.
     */
    public void recolor() {
        for (TilesLine tilesLine : tilesLines) {
            if (tilesLine.attempt != null) {
                tilesLine.recolorTiles();
            }
        }
    }

    /**
     * Returns the index of the currently active line in the grid.
     */
    public int getActiveLineIndex() {
        return activeLineIndex;
    }

    /**
     * Moves to the next line in the grid, if available.
     * If the maximum number of attempts has been reached, stays on the last line.
     */
    public void nextLine() {
        if (++activeLineIndex > Game.AMOUNT_OF_ATTEMPTS) {
            activeLineIndex = Game.AMOUNT_OF_ATTEMPTS;
        }
    }

    /**
     * Cleans and resets all lines in the grid and sets the active line back to the first line.
     */
    public void clean() {
        for (TilesLine line : tilesLines) {
            line.clean();
        }
        activeLineIndex = 0;
    }
}

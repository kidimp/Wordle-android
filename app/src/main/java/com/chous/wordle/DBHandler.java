package com.chous.wordle;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class DBHandler extends SQLiteOpenHelper {
    private static DBHandler instance;
    SQLiteDatabase db;
    private static final String DB_NAME = "wordle-android.db";
    private static final int DB_VERSION = 1;

    private static final String WORDS = "words";
    private static final String WORD = "word";
    private Word word;

    private static final String STATS = "stats";
    private static final String GAMES = "games";
    private static final String WINS = "wins";
    private static final String STREAK = "streak";
    private static final String MAX_STREAK = "max_streak";

    int numberOfGames;
    int numberOfWins;
    int streak;
    int maxStreak;
    boolean previousGameResultIsVictory;
    private boolean isGameFinished = false;


    private DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        boolean isDBExist = isDatabaseExist(context);

        db = this.getWritableDatabase();

        if (!isDBExist) {
            fillInDB();
        }
    }


    public static DBHandler getInstance() {
        if (instance == null) {
            instance = new DBHandler(App.getContext());
        }
        return instance;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }


    @Override
    protected void finalize() {
        db.close();
    }

    public boolean isDatabaseExist(Context context) {
        SQLiteDatabase checkDB = null;
        String fullPath = context.getDatabasePath(DB_NAME).getPath();
        boolean tableExists = false;

        try {
            // Attempt to open the database
            checkDB = SQLiteDatabase.openDatabase(fullPath, null, SQLiteDatabase.OPEN_READONLY);

            // Check if the table exists
            if (checkDB != null) {
                Cursor cursor = checkDB.rawQuery(
                        "SELECT name FROM sqlite_master WHERE type='table' AND name='" + WORDS + "';",
                        null
                );

                // Check if the cursor has any results
                if (cursor != null) {
                    tableExists = cursor.getCount() > 0;
                    cursor.close();
                }
            }

        } catch (Exception e) {
            // Database or table does not exist
        }

        // Close the database if it was opened
        if (checkDB != null) {
            checkDB.close();
        }

        return (checkDB != null) && (tableExists);
    }


    public void fillInDB() {
        db.beginTransaction();

        SQLiteStatement statement = null;

        try {
            InputStream inputStream = App.getContext().getResources().openRawResource(R.raw.wordle_db);
            StringBuilder queriesBuilder = new StringBuilder();

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    queriesBuilder.append(line);
                }
            } catch (IOException e) {
                Log.e("IOException", "IOException while reading from input stream", e);
            }

            String queries = queriesBuilder.toString();

            for (String query : queries.split(";")) {
                try {
                    statement = db.compileStatement(query.trim());
                    statement.execute();
                } catch (SQLException e) {
                    Log.e("SQL Error", "Error executing SQL query: " + query, e);
                } finally {
                    if (statement != null) {
                        statement.close();
                    }
                }
            }

            db.setTransactionSuccessful();

        } catch (Exception e) {
            Log.e("Database Error", "Error while trying to add data to the database", e);
        } finally {
            db.endTransaction();
        }
    }


    public void generateRandomWord() {
        Cursor cursor = db.rawQuery("SELECT * FROM " + WORDS + " ORDER BY RANDOM() LIMIT 1", null);
        if (cursor.moveToFirst()) {
            word = new Word(cursor.getString(1).toUpperCase());
//            word = new Word("RALLY"); // for testing purposes
            Log.d("TARGET WORD", word.getText());
        }
        cursor.close();
    }


    public Word getWord() {
        return word;
    }


    public boolean isAttemptExist(String attempt) {
        Cursor cursor = db.rawQuery("SELECT EXISTS(SELECT  " + WORD + "  FROM "
                + WORDS + " WHERE " + WORD + " = '" + attempt.toLowerCase() + "')", null);
        cursor.moveToFirst();

        // cursor.getInt(0) is 1 if column with value exists
        if (cursor.getInt(0) == 1) {
            cursor.close();
            return true;
        } else {
            cursor.close();
            return false;
        }
    }


    public int getNumberOfGames() {
        Cursor cursor = db.rawQuery("SELECT * FROM " + STATS, null);
        cursor.moveToFirst();
        numberOfGames = cursor.getInt(1);
        cursor.close();

        Log.d("NUMBER OF GAMES", String.valueOf(numberOfGames));

        return numberOfGames;
    }

    public void incrementNumberOfGames() {
        getNumberOfGames();

        numberOfGames++;

        String query = "UPDATE " + STATS + " SET " + GAMES + " = " + numberOfGames + " WHERE id=1";
        db.execSQL(query);
    }


    public int getNumberOfWins() {
        Cursor cursor = db.rawQuery("SELECT * FROM " + STATS, null);
        cursor.moveToFirst();
        numberOfWins = cursor.getInt(2);
        cursor.close();

        Log.d("NUMBER OF GAMES", String.valueOf(numberOfWins));

        return numberOfWins;
    }

    public void incrementNumberOfWins() {
        getNumberOfWins();

        numberOfWins++;

        String query = "UPDATE " + STATS + " SET " + WINS + " = " + numberOfWins + " WHERE id=1";
        db.execSQL(query);
    }


    public void setPreviousGameResult(boolean result) {
        previousGameResultIsVictory = result;
    }

    public boolean getPreviousGameResult() {
        return previousGameResultIsVictory;
    }


    public boolean getIsGameFinished() {
        return isGameFinished;
    }

    public void setIsGameFinished(boolean isGameFinished) {
        this.isGameFinished = isGameFinished;
    }


    public int getStreak() {
        Cursor cursor = db.rawQuery("SELECT * FROM " + STATS, null);
        cursor.moveToFirst();
        streak = cursor.getInt(3);

        cursor.close();

        Log.d("STREAK", String.valueOf(streak));

        return streak;
    }

    public void incrementStreak() {
        getStreak();

        streak++;

        String query = "UPDATE " + STATS + " SET " + STREAK + " = " + streak + " WHERE id=1";
        db.execSQL(query);
    }


    public void resetStreak() {
        String query = "UPDATE " + STATS + " SET " + STREAK + " = 0 WHERE id=1";
        db.execSQL(query);
    }


    public int getMaxStreak() {
        Cursor cursor = db.rawQuery("SELECT * FROM " + STATS, null);
        cursor.moveToFirst();
        maxStreak = cursor.getInt(4);
        cursor.close();

        Log.d("MAX STREAK", String.valueOf(maxStreak));

        return maxStreak;
    }


    public void updateMaxStreak() {
        if (getPreviousGameResult() && getStreak() > getMaxStreak()) {
            String query = "UPDATE " + STATS + " SET " + MAX_STREAK + " = " + streak + " WHERE id=1";
            db.execSQL(query);
        }
    }
}

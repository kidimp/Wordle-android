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

/**
 * The `DBHandler` class extends `SQLiteOpenHelper` and serves as a handler for managing database operations
 * related to the Wordle game. It includes methods for database creation, updating, and various game statistics.
 * <p>
 * To use this class, obtain an instance through the static method `getInstance()`.
 * Subsequent calls to `getInstance()` will return the same instance to maintain a single connection to the database.
 * Example usage to get an instance:
 * DBHandler dbHandler = DBHandler.getInstance();
 * <p>
 * The class includes methods for generating random words, checking if an attempt exists, updating game
 * statistics such as the number of games, wins, streaks, and maximum streaks. It also manages the result of
 * the previous game and tracks whether the current game is finished.
 * <p>
 * See class variables description at the very bottom of this class page.
 * <p>
 * Note: This class assumes the existence of a "wordle-android.db" SQLite database.
 */
public class DBHandler extends SQLiteOpenHelper {
    private static DBHandler instance;
    private final SQLiteDatabase db;
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

    private int numberOfGames;
    private int numberOfWins;
    private int streak;
    private boolean isPreviousGameResultVictory;
    private boolean isGameFinished = false;

    /**
     * Constructs a new instance of the `DBHandler` class, initializing the SQLite database connection
     * and performing necessary setup operations. This constructor is private to enforce the use
     * of the singleton pattern, ensuring that only one instance of `DBHandler` is created.
     * <br>
     * {@link #fillInDB()} - If the database did not exist before, fill it with initial data
     * <br>
     * {@link #getWritableDatabase()} - Get a writable database instance.
     * @param context The application context used to create the database.
     * @value <b>isDBExist</b> - Check if the proper database already exists by calling the isDatabaseExist method.
     * Proper database means that we created and filled it. Somehow, when we install and run app
     * for the very first time, db created automatically before our initialization. Why?
     */
    private DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        boolean isDBExist = isDatabaseExist(context);

        db = this.getWritableDatabase();

        if (!isDBExist) {
            fillInDB();
        }
    }

    /**
     * Retrieves the singleton instance of the `DBHandler`. If the instance does not exist, it creates one using
     * the application context. This method ensures that only one instance of `DBHandler` is created and shared
     * throughout the application.
     *
     * @return The singleton instance of the `DBHandler`.
     */
    public static DBHandler getInstance() {
        if (instance == null) {
            instance = new DBHandler(App.getContext());
        }
        return instance;
    }

    /**
     * Overrides the `onCreate` method from the `SQLiteOpenHelper` class. This method should called when the database
     * is created for the first time. But somehow, when we install and run app for the very first time,
     * db created automatically before we reach method `onCreate`. That's why method `onCreate` is not calling,
     * because program thinks, that db already exist.
     * Actual creation and initialization of the database are handled
     * in the constructor, this method remains empty.
     *
     * @param db The SQLite database instance.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    /**
     * Overrides the `onUpgrade` method from the `SQLiteOpenHelper` class. This method is called when the database
     * needs to be upgraded, typically by altering the structure or migrating data. As no specific upgrade logic is
     * implemented in this application, this method remains empty.
     *
     * @param db         The SQLite database instance.
     * @param oldVersion The old version number of the database.
     * @param newVersion The new version number of the database.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    /**
     * Overrides the `finalize` method to ensure that the SQLite database is closed when the `DBHandler` instance
     * is garbage collected. This method helps in releasing resources associated with the database connection.
     */
    @Override
    protected void finalize() {
        db.close();
    }

    /**
     * Checks whether the wordle-android.db exists and contains table `words`.
     * This method is used during the initialization of the `DBHandler` to determine if the database
     * needs to be created and filled with initial data.
     *
     * @param context The application context used to get the path to the database file.
     * @return True if the database file exists and contains the expected table, false otherwise.
     */
    public boolean isDatabaseExist(Context context) {
        SQLiteDatabase checkDB = null;
        String fullPath = context.getDatabasePath(DB_NAME).getPath();
        boolean tableExists = false;

        try {
            // Attempt to open the database in read-only mode.
            checkDB = SQLiteDatabase.openDatabase(fullPath, null, SQLiteDatabase.OPEN_READONLY);

            // Check if the db exists (not null)
            if (checkDB != null) {
                // Check if the table `words` exists
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

    /**
     * Fills the wordle-android.db with initial data from a raw resource file (R.raw.wordle_db).
     * This method is called during the initialization of the `DBHandler` to populate the database with
     * essential data required for the Wordle game.
     * <p>
     * We use a database transaction to ensure atomicity of database operations. The operation is either
     * performed in its entirety or not at all. This significantly improve performance by reducing the number of commits.
     * <p>
     * We use SQLiteStatement for executing SQL queries. Our queries are similar and are executed multiple times.
     * Prepared statements are precompiled, which can improve performance.
     * <p>
     * We use an InputStream to the raw resource file containing SQL queries.
     * We use a StringBuilder to build SQL queries from the raw resource file content. This can reduce I/O overhead.
     */
    public void fillInDB() {
        db.beginTransaction();

        SQLiteStatement statement = null;

        try {
            InputStream inputStream = App.getContext().getResources().openRawResource(R.raw.wordle_db);
            StringBuilder queriesBuilder = new StringBuilder();

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
                // Read lines from the input stream and append them to the StringBuilder.
                String line;
                while ((line = reader.readLine()) != null) {
                    queriesBuilder.append(line);
                }
            } catch (IOException e) {
                Log.e("IOException", "IOException while reading from input stream", e);
            }

            String queries = queriesBuilder.toString();

            // Split the string of queries into individual queries and execute them.
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

    /**
     * Retrieves a random word from the "words" table in the SQLite database and initializes the 'word' variable
     * with the retrieved word. The method uses a SQL query to randomly select one word from the table.
     * Additionally, it logs the selected word for debugging purposes.
     */
    public void generateRandomWord() {
        Cursor cursor = db.rawQuery("SELECT * FROM " + WORDS + " ORDER BY RANDOM() LIMIT 1", null);
        if (cursor.moveToFirst()) {
            word = new Word(cursor.getString(1).toUpperCase());
//            word = new Word("RALLY"); // for debugging purposes
            Log.d("TARGET WORD", word.getText());
        }
        cursor.close();
    }

    /**
     * It represents the target word.
     *
     * @return The Word object.
     */
    public Word getWord() {
        return word;
    }

    /**
     * Checks if a given attempt word exists in the "words" table of the SQLite database.
     *
     * @param attempt The attempt word to check for existence in the database.
     * @return True if the attempt word exists in the database, false otherwise.
     */
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

    /**
     * Returns the total number of games played from the "stats" table in the SQLite database.
     */
    public int getNumberOfGames() {
        Cursor cursor = db.rawQuery("SELECT * FROM " + STATS, null);
        cursor.moveToFirst();
        numberOfGames = cursor.getInt(1);
        cursor.close();

        Log.d("NUMBER OF GAMES", String.valueOf(numberOfGames));

        return numberOfGames;
    }

    /**
     * Increments the total number of games played in the "stats" table of the SQLite database and updates the record.
     */
    public void incrementNumberOfGames() {
        getNumberOfGames();

        numberOfGames++;

        String query = "UPDATE " + STATS + " SET " + GAMES + " = " + numberOfGames + " WHERE id=1";
        db.execSQL(query);
    }

    /**
     * Returns the total number of game wins from the "stats" table in the SQLite database.
     */
    public int getNumberOfWins() {
        Cursor cursor = db.rawQuery("SELECT * FROM " + STATS, null);
        cursor.moveToFirst();
        numberOfWins = cursor.getInt(2);
        cursor.close();

        Log.d("NUMBER OF GAMES", String.valueOf(numberOfWins));

        return numberOfWins;
    }

    /**
     * Increments the total number of game wins in the "stats" table of the SQLite database and updates the record.
     */
    public void incrementNumberOfWins() {
        getNumberOfWins();

        numberOfWins++;

        String query = "UPDATE " + STATS + " SET " + WINS + " = " + numberOfWins + " WHERE id=1";
        db.execSQL(query);
    }

    /**
     * Retrieves the result of the previous game.
     *
     * @return True if the previous game ended in victory, false if it ended in defeat.
     */
    public boolean getPreviousGameResult() {
        return isPreviousGameResultVictory;
    }

    /**
     * Sets the result of the previous game (victory or defeat).
     *
     * @param result A boolean indicating whether the previous game ended in victory (true) or defeat (false).
     */
    public void setPreviousGameResult(boolean result) {
        isPreviousGameResultVictory = result;
    }

    /**
     * Checks whether the current game is marked as finished.
     *
     * @return True if the current game is finished, false otherwise.
     */
    public boolean getIsGameFinished() {
        return isGameFinished;
    }

    /**
     * Sets the status indicating whether the current game is finished.
     *
     * @param isGameFinished A boolean indicating whether the current game is finished (true) or not (false).
     */
    public void setIsGameFinished(boolean isGameFinished) {
        this.isGameFinished = isGameFinished;
    }

    /**
     * Returns the current streak value from the "stats" table in the SQLite database.
     */
    public int getStreak() {
        Cursor cursor = db.rawQuery("SELECT * FROM " + STATS, null);
        cursor.moveToFirst();
        streak = cursor.getInt(3);

        cursor.close();

        Log.d("STREAK", String.valueOf(streak));

        return streak;
    }

    /**
     * Increments the current streak value in the "stats" table of the SQLite database and updates the record.
     */
    public void incrementStreak() {
        getStreak();

        streak++;

        String query = "UPDATE " + STATS + " SET " + STREAK + " = " + streak + " WHERE id=1";
        db.execSQL(query);
    }

    /**
     * Resets the current streak value to zero in the "stats" table of the SQLite database.
     */
    public void resetStreak() {
        String query = "UPDATE " + STATS + " SET " + STREAK + " = 0 WHERE id=1";
        db.execSQL(query);
    }

    /**
     * Returns the maximum streak value from the "stats" table in the SQLite database.
     */
    public int getMaxStreak() {
        Cursor cursor = db.rawQuery("SELECT * FROM " + STATS, null);
        cursor.moveToFirst();
        int maxStreak = cursor.getInt(4);
        cursor.close();

        Log.d("MAX STREAK", String.valueOf(maxStreak));

        return maxStreak;
    }

    /**
     * Updates the maximum streak value in the "stats" table if the previous game was a victory and the current
     * streak value is greater than the existing maximum streak.
     */
    public void updateMaxStreak() {
        if (getPreviousGameResult() && getStreak() > getMaxStreak()) {
            String query = "UPDATE " + STATS + " SET " + MAX_STREAK + " = " + streak + " WHERE id=1";
            db.execSQL(query);
        }
    }
}

// Class variables description
/*
    DBHandler instance - Singleton instance of the DBHandler class. Ensures that only one instance of DBHandler is created and shared throughout the application.
    SQLiteDatabase db - SQLite database instance used for database operations within the DBHandler class.
    String DB_NAME - Name of the SQLite database file used by the application.
    int DB_VERSION - Version number of the SQLite database schema. Incrementing this value triggers the onUpgrade method for potential database schema changes.
    String WORDS - Name of the table in the database containing words used in the Wordle game.
    String WORD - Name of the column in the "words" table representing individual words used in the Wordle game.
    Word word - Represents a Word object containing the target word for the Wordle game.
    String STATS - Name of the table in the database containing statistical data for the Wordle game.
    String GAMES - Name of the column in the "stats" table representing the total number of games played.
    String WINS - Name of the column in the "stats" table representing the total number of game wins.
    String STREAK - Name of the column in the "stats" table representing the current game streak.
    String MAX_STREAK - Name of the column in the "stats" table representing the maximum game streak achieved.
    int numberOfGames - Holds the total number of games played, synchronized with the "games" column in the "stats" table.
    int numberOfWins - Holds the total number of game wins, synchronized with the "wins" column in the "stats" table.
    int streak - Holds the current game streak, synchronized with the "streak" column in the "stats" table.
    int maxStreak - Holds the maximum game streak achieved, synchronized with the "max_streak" column in the "stats" table.
    boolean isPreviousGameResultVictory - Indicates whether the result of the previous game was a victory (true) or defeat (false).
    boolean isGameFinished - Indicates whether the current game is marked as finished (true) or ongoing (false).
 */

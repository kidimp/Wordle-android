package com.chous.wordle;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHandler extends SQLiteOpenHelper {
    private static final String DB_NAME = "wordle-android.db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "words";
    private static final String NAME_COL = "word";
    private Word word;
    private static DBHandler instance;
    SQLiteDatabase db = this.getReadableDatabase();

    private DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
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


    public void generateRandomWord() {
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " ORDER BY RANDOM() LIMIT 1", null);
        if (cursor.moveToFirst()) {
            word = new Word(cursor.getString(1).toUpperCase());
            word = new Word("RALLY");
            Log.d("TARGET WORD ----------> ", word.getText());
        }
        cursor.close();
    }


    public Word getWord() {
        return word;
    }


    public boolean isAttemptExist(String attempt) {
        Cursor cursor = db.rawQuery("SELECT EXISTS(SELECT  " + NAME_COL + "  FROM "
                + TABLE_NAME + " WHERE " + NAME_COL + " = '" + attempt.toLowerCase() + "')", null);
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
}

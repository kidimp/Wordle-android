package com.chous.wordle;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {
    private static DBHandler instance;

    private DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public static DBHandler getInstance() {
        if (instance == null) {
            instance = new DBHandler(App.getContext());
        }
        return instance;
    }


    private static final String DB_NAME = "wordle-android";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "wordle";
    private static final String NAME_COL = "words";
    private String word;





    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME
                + " (" + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT)";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void generateRandomWord(){
        word = "chous".toUpperCase();
    }

    public String getWord() {
        return word;
    }

    public boolean isAttemptExist(String attempt){
        return true;
    }
}

package com.example.vocation;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBAccess {

    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DBAccess instance;

    private DBAccess(Context context) {
        this.openHelper = new DBOpenHelper(context);
    }

    public static DBAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DBAccess(context);
        }
        return instance;
    }

    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    public SQLiteDatabase getDatabase() {
        return database;
    }
}
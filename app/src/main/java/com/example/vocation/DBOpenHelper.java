package com.example.vocation;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DBOpenHelper extends SQLiteAssetHelper{
    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "peopledb.db";
    Context context = null;

    public DBOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onOpen(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        new DBOpenHelper(context);
        DBAccess.getInstance(context);
    }
}

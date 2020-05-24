package com.example.vocation;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DBOpenHelper extends SQLiteAssetHelper{
    public static final int DATABASE_VERSION = 3;
    public static final String DATABASE_NAME = "peopledb.db";
    Context context = null;

    public DBOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        /**/
//        db.execSQL("delete from candidates where ID = 1");
//        db.execSQL("delete from candidate_people");
//        db.execSQL("update candidates set Votes=0 where ID=6");

//        db.execSQL("drop table if exists 'candidates'");
//        db.execSQL("drop table if exists 'candidate_people'");
//        db.execSQL("create table if not exists 'candidates' (ID INT, Lastname VARCHAR(45), Firstname VARCHAR(45), Information TEXT, Votes INT DEFAULT  0);");
//        db.execSQL("create table if not exists 'candidate_people' (Candidate_ID INT, People_ID INT);");
//        db.execSQL("insert into people values (6, '000315742', 'Зеленський', 'Володимир', 1, 1, 1, 1);");
//        db.execSQL("insert into candidates values (6, 'Зеленський', 'Володимир', 'інфо', 0);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//            db.execSQL("update people set passport_ID='000000001',Firstname='root',Lastname='root' where ID=1");
//            db.execSQL("update people set Lastname='Тодорук' where ID=2");
//            db.execSQL("update people set Lastname='Іванко' where ID=4");
//            db.execSQL("update people set Lastname='Стародуб' where ID=5");
    }
}

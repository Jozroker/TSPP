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
        /**/
        if (DATABASE_VERSION == 1) {
            db.execSQL("DROP TABLE IF EXISTS 'candidates';");
            db.execSQL("CREATE TABLE IF NOT EXISTS 'candidates'(" +
                    "'ID' int NOT NULL," +
                    "'Lastname' varchar(45) NOT NULL," +
                    "'Firstname' varchar(45) NOT NULL," +
                    "'Information' text," +
                    "'Votes' int NOT NULL DEFAULT 0);");
            db.execSQL("DROP TABLE IF EXISTS 'candidate_people';");
            db.execSQL("CREATE TABLE IF NOT EXISTS 'candidate_people' (" +
                    "'Candidate_ID' int NOT NULL," +
                    "'People_ID' int NOT NULL);");
            db.execSQL("DROP TABLE IF EXISTS 'people';");
            db.execSQL("CREATE TABLE IF NOT EXISTS 'people' (" +
                    "'ID' INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE," +
                    "'passport_ID' TEXT NOT NULL UNIQUE," +
                    "'Lastname' TEXT NOT NULL," +
                    "'Firstname' TEXT NOT NULL," +
                    "'correct_age' INTEGER NOT NULL," +
                    "'can_vote' INTEGER NOT NULL," +
                    "'LiveinUkr' INTEGER NOT NULL," +
                    "'speak_Ukraine' INTEGER NOT NULL);");
            db.execSQL("INSERT INTO 'people' ('ID','passport_ID','Lastname','Firstname','correct_age','can_vote','LiveinUkr','speak_Ukraine') VALUES (1,'000000001','root','root',1,1,1,1)," +
                    " (2,'000245981','Тодорук','Максим',1,0,1,1)," +
                    " (3,'000875461','Щукін','Євген',1,1,1,1)," +
                    " (4,'000365412','Іванко','Андрій',1,1,1,0)," +
                    " (5,'000123789','Стародуб','Олексій',1,1,1,1)," +
                    " (6,'000642341','Зеленський','Володимир',1,1,1,1);");
            db.execSQL("INSERT INTO 'candidates' ('ID','Lastname','Firstname','Information','Votes') VALUES (6,'Зеленський','Володимир','інфо',0);");
        }
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

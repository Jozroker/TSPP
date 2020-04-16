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
        this.database = openHelper.getReadableDatabase();
    }

    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

//    public void getValues() {
//        String sql = "";
//        sql = "SELECT * FROM people;";
//        Cursor cursor = database.rawQuery(sql, null);
//        System.out.println(cursor.getColumnCount());
//        System.out.println(cursor.getCount());
//        StringBuilder builder = new StringBuilder();
//        int j = 0;
//        cursor.moveToFirst();
//        while (!cursor.isAfterLast()) {
//            while (j < cursor.getColumnCount()) {
//                builder.append(cursor.getString(j));
//                builder.append(", ");
//                j++;
//            }
//            cursor.moveToNext();
//            builder.append("\n");
//            j = 0;
//        }
//
//        cursor.close();
//        System.out.println(builder.toString());
//    }



    public SQLiteDatabase getDatabase() {
        return database;
    }
}

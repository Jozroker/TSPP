package com.example.vocation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;

public class LoginChecker {

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static boolean autentefication(Context context, String id, String fname, String lname) {
        boolean value = false;
        DBAccess dbAccess = DBAccess.getInstance(context);
        dbAccess.open();
        List<String> pass_id = new ArrayList<>();
        @SuppressLint("Recycle")
        Cursor cursor = dbAccess.getDatabase().rawQuery("SELECT * FROM people;", null);
        cursor.moveToFirst();
        int i = 0;
        while (i < cursor.getCount()) {
            pass_id.add(cursor.getString(1));
            cursor.moveToNext();
            i++;
        }

        if (pass_id.contains(id)) {
            int n = 0;
            cursor.moveToFirst();
            while (n < cursor.getCount()) {
                if (cursor.getString(1).equals(id)) {
                    if (cursor.getString(2).equals(lname) &&
                        cursor.getString(3).equals(fname)) {
                        String correctAge = cursor.getString(4);
                        String canVote = cursor.getString(5);
                        String liveInUkr = cursor.getString(6);
                        String speakUkr = cursor.getString(7);
                        MainActivity.currentUser = new String[]{id, fname, lname, correctAge, canVote, liveInUkr, speakUkr};
                        value = true;
                    } else {
                        Toast.makeText(context,"Wrong input values", Toast.LENGTH_SHORT).show();
                    }
                    break;
                }
                cursor.moveToNext();
                n++;
            }
        } else {
            Toast.makeText(context,"Incorrect passport ID", Toast.LENGTH_SHORT).show();
        }
        dbAccess.close();
        return value;
    }
}

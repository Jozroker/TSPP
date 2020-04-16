package com.example.vocation;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar !=null) {
            actionBar.hide();
        }


            DBAccess dbAccess = DBAccess.getInstance(MainActivity.this);
            dbAccess.open();
            dbAccess.getValues();
            dbAccess.close();


    }

    public void onClickLogin(View view) {

    }
}

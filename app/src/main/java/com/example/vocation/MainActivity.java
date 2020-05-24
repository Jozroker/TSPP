package com.example.vocation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText editTextLname;
    private EditText editTextFname;
    private EditText editTextID;
    protected static String[] currentUser;
    protected static String currentVotingDatabase;
    protected static String currentCandidatesDatabase;
    private static Context myAppContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myAppContext = getApplicationContext();
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        editTextLname = findViewById(R.id.editTextLname);
        editTextFname = findViewById(R.id.editTextFname);
        editTextID = findViewById(R.id.editTextID);

    }
    @SuppressLint("ResourceAsColor")
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void onClickLogin(View view) {
        /**
         *
         * Uncomment main login method
         *
         */
        switch (view.getId()) {
            case R.id.hiddenButton:
                Intent test = new Intent(this, TestActivity.class);
                startActivity(test);
                break;
            case R.id.buttonLogin:
                if (LoginChecker.autentefication(this, editTextID.getText().toString(),
                        editTextFname.getText().toString(), editTextLname.getText().toString())) {
                    Intent intent = new Intent(this, VotingsActivity.class);
                    startActivity(intent);
                }
                break;
        }

//        Intent intent = new Intent(getApplicationContext(),VotingsActivity.class);
//        startActivity(intent);

        /**
         *
         */


    }

    public static Context getMainAppContext() {
        return myAppContext;
    }
}

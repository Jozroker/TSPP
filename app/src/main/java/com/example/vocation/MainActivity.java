package com.example.vocation;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        editTextLname = findViewById(R.id.editTextLname);
        editTextFname = findViewById(R.id.editTextFname);
        editTextID = findViewById(R.id.editTextID);

    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void onClickLogin(View view) {
         if (LoginChecker.autentefication(this, editTextID.getText().toString(),
                editTextFname.getText().toString(), editTextLname.getText().toString())) {
             Intent intent = new Intent(getApplicationContext(),VotingsActivity.class);
             startActivity(intent);
         }
    }
}

package com.example.vocation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static EditText editTextLname;
    private static EditText editTextFname;
    private static EditText editTextID;
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
    public void onClickLogin(View view) {
        Intent intent = new Intent(getApplicationContext(),VotingsActivity.class);
        startActivity(intent);
    }
}

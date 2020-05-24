package com.example.vocation;

import android.database.Cursor;
import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CandidatesActivity extends AppCompatActivity {
    private static RecyclerView recyclerView;
    private static CandidateListAdapter candidateListAdapter;
    private ArrayList<Candidate> candidates = new ArrayList<>();
    private List<String> candidatesDB = new ArrayList<>();
    private DBAccess database = DBAccess.getInstance(MainActivity.getMainAppContext());

    {
        candidatesDB.clear();
        candidatesDB.add("candidates");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String sql = "SELECT Firstname, Lastname, Information, Votes FROM  '" + candidatesDB.get(VotingAdapter.Position) + "';";
        database.open();
        Cursor cursor = database.getDatabase().rawQuery(sql, null);
        int j = 0;
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String fname = "";
            String lname = "";
            String info = "";
            int votes = 0;
            while (j < cursor.getColumnCount()) {
                if (j == 0) {
                    fname = cursor.getString(j);
                } else if (j == 1) {
                    lname = cursor.getString(j);
                } else if (j == 2) {
                    info = cursor.getString(j);
                } else {
                    votes = cursor.getInt(j);
                }
                j++;
            }
            candidates.add(new Candidate(fname, lname, info, votes));
            cursor.moveToNext();
            j = 0;
        }
        cursor.close();
        setContentView(R.layout.activity_candidates_list);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        recyclerView = findViewById(R.id.recyclerView1);
        candidateListAdapter = new CandidateListAdapter(candidates, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(candidateListAdapter);

    }
}
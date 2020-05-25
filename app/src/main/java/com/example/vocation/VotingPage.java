package com.example.vocation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class VotingPage extends AppCompatActivity {
    private static RecyclerView recyclerView;
    private static CandidateAdapter candidateAdapter;
    private ArrayList<Candidate> candidates = new ArrayList<>();
    private List<String> candidatesDB = new ArrayList<>();
    private DBAccess database = DBAccess.getInstance(MainActivity.getMainAppContext());
    int currentUserId = Integer.parseInt(MainActivity.currentUser[0]);
    public static Candidate selectedCandidate;
    private Button beCandidateButton;
    private Button voteButton;
    private static VotingPage instance;

    public static VotingPage getInstance() {
        return instance;
    }

    {
        MainActivity.currentVotingDatabase = "candidate_people";
        MainActivity.currentCandidatesDatabase = "candidates";
        candidatesDB.clear();
        candidatesDB.add("candidates");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;
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
        setContentView(R.layout.activity_voting_page);
        beCandidateButton = findViewById(R.id.buttonCandidate);
        voteButton = findViewById(R.id.buttonVote);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar !=null) {
            actionBar.hide();
        }
        recyclerView=findViewById(R.id.recyclerView1);
        candidateAdapter=new CandidateAdapter(candidates);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(candidateAdapter);
        checkIsVote();
        checkIsCandidate();
    }

    @SuppressLint("ResourceAsColor")
    private void checkIsVote() {
        /**/
        String sql = "SELECT  * FROM  " + MainActivity.currentVotingDatabase + " WHERE  People_ID = '" + currentUserId + "';";
        Cursor cursor = database.getDatabase().rawQuery(sql, null);
        int canVote = Integer.parseInt(MainActivity.currentUser[4]);
        if (cursor.getCount() != 0 || canVote == 0) {
            voteButton.setEnabled(false);
            voteButton.setBackgroundColor(R.color.cardview_dark_background);
        }
    }

    @SuppressLint("ResourceAsColor")
    private void checkIsCandidate() {
        String sql = "SELECT  * FROM  " + MainActivity.currentCandidatesDatabase + " WHERE  ID = '" + currentUserId + "';";
        Cursor cursor = database.getDatabase().rawQuery(sql, null);
        int correctAge = Integer.parseInt(MainActivity.currentUser[3]);
        int liveInUkr = Integer.parseInt(MainActivity.currentUser[5]);
        int speakUkr = Integer.parseInt(MainActivity.currentUser[6]);
        if (cursor.getCount() != 0 || correctAge == 0 || liveInUkr == 0 || speakUkr == 0) {
            beCandidateButton.setEnabled(false);
            beCandidateButton.setBackgroundColor(R.color.cardview_dark_background);
        }
    }

    public void onClickBeCandidate(View view) {
        Integer id = Integer.parseInt(MainActivity.currentUser[0]);
        String firstName = MainActivity.currentUser[1];
        String lastName = MainActivity.currentUser[2];
        String sql = "insert into candidates values (" + id + ", '" + lastName + "', '" + firstName + "', 'інфо', 0);";
        database.getDatabase().execSQL(sql);
        refresh();
    }

    public void onClickVote(View view) {
        Intent intent = new Intent(this, CandidatesActivity.class);
        startActivity(intent);
    }

    public  void refresh() {
        finish();
        startActivity(getIntent());
    }
}

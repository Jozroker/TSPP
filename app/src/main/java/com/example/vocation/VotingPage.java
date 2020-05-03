package com.example.vocation;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class VotingPage extends AppCompatActivity {
    private static RecyclerView recyclerView;
    private static CandidateAdapter candidateAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voting_page);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar !=null) {
            actionBar.hide();
        }
        recyclerView=findViewById(R.id.recyclerView);
        ArrayList<Candidate> candidates = new ArrayList<>();
        candidates.add(new Candidate("Володиимр","Зеленський","Some info",0));
        candidateAdapter=new CandidateAdapter(candidates);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.getMainAppContext()));
        recyclerView.setAdapter(candidateAdapter);
    }
}

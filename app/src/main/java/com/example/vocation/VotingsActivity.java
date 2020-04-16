package com.example.vocation;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class VotingsActivity extends AppCompatActivity {
    private static RecyclerView recyclerView;
    private static VotingAdapter votingAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_votings);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar !=null) {
            actionBar.hide();
        }
        recyclerView=findViewById(R.id.recyclerView);
        ArrayList<Voting> votings = new ArrayList<>();
        votings.add(new Voting("Вибори Президента","20.10.2020"));
        votingAdapter=new VotingAdapter(votings);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(votingAdapter);
    }
}

package com.example.vocation;

import android.app.Activity;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CandidateListAdapter extends RecyclerView.Adapter<CandidateListAdapter.CandidateViewHolder> {
    private ArrayList<Candidate> candidates;
    private Activity activity;
    private DBAccess database = DBAccess.getInstance(MainActivity.getMainAppContext());
//    private final View.OnClickListener listener = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            doVote(v);
//        }
//    };

    public CandidateListAdapter(ArrayList<Candidate> candidates, Activity main) {
        this.candidates = candidates;
        this.activity = main;
    }

    @NonNull
    @Override
    public CandidateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.candidate, parent, false);
//        view.setOnClickListener(listener);
        return new CandidateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CandidateViewHolder holder, final int position) {
        Candidate candidate = candidates.get(position);
        holder.textViewCandidateName.setText(candidate.getSurname() + " " + candidate.getName());
        holder.textViewInfo.setText(candidate.getInfo());
        holder.textViewVotes.setText("Кількість голосів: " + candidate.getVotes());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doVote(v, position);
            }
        });
//        VotingPage.selectedCandidate = candidate;
//        String query = "SELECT ID FROM  candidates WHERE Firstname = '" + candidate.getName() + "' AND Lastname = '" + candidate.getSurname() + "';";
//        Cursor cursor = database.getDatabase().rawQuery(query, null);
//        cursor.moveToFirst();
//        Integer candidateId = cursor.getInt(0);
//        cursor.close();
//        Integer peopleId = Integer.parseInt(MainActivity.currentUser[0]);
//        String sql = "INSERT INTO candidate_people VALUES (" + candidateId + ", " + peopleId + ");";
//        database.getDatabase().execSQL(sql);
//        String query2 = "SELECT Votes FROM candidates WHERE ID = " + candidateId + ";";
//        Cursor cursor2 = database.getDatabase().rawQuery(query2, null);
//        cursor2.moveToFirst();
//        Integer candidateVotes = cursor2.getInt(0) + 1;
//        cursor2.close();
//        database.getDatabase().execSQL("update candidates set Votes = " + candidateVotes + " where ID = " + candidateId + ";");
//        activity.finish();
    }

    private void doVote(View view, Integer position) {
//        Integer position = view.getVerticalScrollbarPosition();
//        Integer position = (Integer) view.getTag();
        Candidate candidate = candidates.get(position);
        String query = "SELECT ID FROM  candidates WHERE Firstname = '" + candidate.getName() + "' AND Lastname = '" + candidate.getSurname() + "';";
        Cursor cursor = database.getDatabase().rawQuery(query, null);
        cursor.moveToFirst();
        Integer candidateId = cursor.getInt(0);
        cursor.close();
        Integer peopleId = Integer.parseInt(MainActivity.currentUser[0]);
        String sql = "INSERT INTO candidate_people VALUES (" + candidateId + ", " + peopleId + ");";
        database.getDatabase().execSQL(sql);
        String query2 = "SELECT Votes FROM candidates WHERE ID = " + candidateId + ";";
        Cursor cursor2 = database.getDatabase().rawQuery(query2, null);
        cursor2.moveToFirst();
        Integer candidateVotes = cursor2.getInt(0) + 1;
        cursor2.close();
        database.getDatabase().execSQL("update candidates set Votes = " + candidateVotes + " where ID = " + candidateId + ";");
        activity.finish();
        VotingPage page = VotingPage.getInstance();
        page.refresh();
//        activity.getParent().closeContextMenu();
//        activity.getParent().finish();
//        activity.getParent().startActivity(activity.getParent().getIntent());
//        activity.finish();
    }

    @Override
    public int getItemCount() {
        return candidates.size();
    }


    class CandidateViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewCandidateName;
        private TextView textViewInfo;
        private TextView textViewVotes;

        public CandidateViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewCandidateName = itemView.findViewById(R.id.textViewCandidateName);
            textViewInfo = itemView.findViewById(R.id.textViewInfo);
            textViewVotes = itemView.findViewById(R.id.textViewVotes);
        }
    }
}

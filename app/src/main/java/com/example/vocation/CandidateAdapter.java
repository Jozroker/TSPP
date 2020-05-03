package com.example.vocation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CandidateAdapter extends RecyclerView.Adapter<CandidateAdapter.CandidateViewHolder> {
    private ArrayList<Candidate> candidates;
    public CandidateAdapter(ArrayList<Candidate> candidates) {this.candidates=candidates;}
    @NonNull
    @Override
    public CandidateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.candidate, parent, false);
        return new CandidateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CandidateViewHolder holder, int position) {
        Candidate candidate = candidates.get(position);
        holder.textViewCandidateName.setText(candidate.getSurname()+" "+candidate.getName());
        holder.textViewInfo.setText(candidate.getInfo());
        holder.textViewVotes.setText("Кількість голосів: "+candidate.getVotes());
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
            textViewCandidateName=itemView.findViewById(R.id.textViewCandidateName);
            textViewInfo=itemView.findViewById(R.id.textViewInfo);
            textViewVotes=itemView.findViewById(R.id.textViewVotes);
        }
    }
}

package com.example.vocation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VotingAdapter extends RecyclerView.Adapter<VotingAdapter.VotingViewHolder> {
    private ArrayList<Voting> votings;
    public VotingAdapter(ArrayList<Voting> votings) {this.votings=votings;}
    @NonNull
    @Override
    public VotingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.voting, parent, false);
        return new VotingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VotingViewHolder holder, int position) {
        Voting voting = votings.get(position);
        holder.textViewName.setText(voting.getName());
        holder.textViewDate.setText(voting.getDate());
    }

    @Override
    public int getItemCount() {
        return votings.size();
    }



    class VotingViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewName;
        private TextView textViewDate;
        public VotingViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName=itemView.findViewById(R.id.textViewName);
            textViewDate=itemView.findViewById(R.id.textViewDate);
        }
    }
}

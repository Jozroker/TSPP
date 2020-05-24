package com.example.vocation;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VotingAdapter extends RecyclerView.Adapter<VotingAdapter.VotingViewHolder> {
    private ArrayList<Voting> votings;
    public static int Position;
    public VotingAdapter(ArrayList<Voting> votings) {this.votings=votings;}
    private final View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.getMainAppContext(), VotingPage.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            MainActivity.getMainAppContext().startActivity(intent);
            System.out.println();
        }
    };
//    private final AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
//        @Override
//        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//            Intent intent = new Intent(MainActivity.getMainAppContext(), VotingPage.class);
//            Position = position;
//            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            MainActivity.getMainAppContext().startActivity(intent);
//        }
//    };

    @NonNull
    @Override
    public VotingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.voting, parent, false);
        view.setOnClickListener(listener);
        return new VotingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VotingViewHolder holder, int position) {
        Voting voting = votings.get(position);
        holder.textViewName.setText(voting.getName());
        holder.textViewDate.setText(voting.getDate());
        System.out.println(position);
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

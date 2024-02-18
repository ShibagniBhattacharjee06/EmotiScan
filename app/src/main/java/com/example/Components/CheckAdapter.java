package com.example.Components;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Model.Submission;
import com.example.newproject.R;

import java.util.ArrayList;

public class CheckAdapter extends RecyclerView.Adapter<CheckAdapter.ViewHolder>{


    ArrayList<Submission> list;
    Context context;

    public CheckAdapter(ArrayList<Submission> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_check_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Submission cheklist = list.get(position);
        holder.moodText.setText(cheklist.getMood());
        holder.dateText.setText(cheklist.getDate());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent = new Intent(context, NextDetailsView.class);
            intent.putExtra("fulldetails",cheklist.getFulldetails());
            intent.putExtra("items",cheklist.getItems());
            intent.putExtra("mood",cheklist.getMood());
            intent.putExtra("date",cheklist.getDate());
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView moodText, dateText;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            moodText = itemView.findViewById(R.id.moodText);
            dateText = itemView.findViewById(R.id.date);

        }
    }








}

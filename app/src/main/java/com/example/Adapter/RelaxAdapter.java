package com.example.Adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Model.youtube;
import com.example.newproject.R;

import java.util.ArrayList;

public class RelaxAdapter extends RecyclerView.Adapter<RelaxAdapter.ViewHolder>{


    ArrayList<youtube> list;
    Context context;
    private YoutubeAdapter.OnItemClickListener onItemClickListener;

    public RelaxAdapter(ArrayList<youtube> list, Context context) {
        this.list = list;
        this.context = context;
    }
    public interface OnItemClickListener {
        void onItemClick(String videoUrl);
    }

    // Method to set the click listener
    public void setOnItemClickListener(YoutubeAdapter.OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    @NonNull
    @Override
    public RelaxAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.youtube,parent,false);
        return new RelaxAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RelaxAdapter.ViewHolder holder, int position) {
        youtube youtube = list.get(position);
        holder.name.setText(youtube.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String videoUrl = youtube.getLink();
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(videoUrl);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.youtubename);
        }
    }
}

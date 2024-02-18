package com.example.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Community.ComFragment.ComAdapter;
import com.example.Model.Post;
import com.example.Model.youtube;
import com.example.newproject.R;

import java.util.ArrayList;

public class YoutubeAdapter extends RecyclerView.Adapter<YoutubeAdapter.ViewHolder> {

    ArrayList<youtube> list;
    Context context;
    private OnItemClickListener onItemClickListener;

    public YoutubeAdapter(ArrayList<youtube> list, Context context) {
        this.list = list;
        this.context = context;
    }
    public interface OnItemClickListener {
        void onItemClick(String videoUrl);
    }

    // Method to set the click listener
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    @NonNull
    @Override
    public YoutubeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.youtube,parent,false);
        return new YoutubeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull YoutubeAdapter.ViewHolder holder, int position) {
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

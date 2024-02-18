package com.example.Community.ComFragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Components.CheckAdapter;
import com.example.Model.Post;
import com.example.Model.Submission;
import com.example.Model.UserProfile;
import com.example.newproject.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;

public class ComAdapter extends RecyclerView.Adapter<ComAdapter.ViewHolder> {

    private ArrayList<Post> list;
    Context context;

    public ComAdapter(ArrayList<Post> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ComAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.post_view,parent,false);
        return new ComAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ComAdapter.ViewHolder holder, int position) {
        Post item = list.get(position);

            holder.PostedText.setText(item.getText());
            holder.name.setText(item.getName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView PostedText,name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            PostedText = itemView.findViewById(R.id.postedText);
            name = itemView.findViewById(R.id.nameText);

        }
    }
}

package com.example.Community.ComFragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.Components.CheckAdapter;
import com.example.Model.Post;
import com.example.Model.Submission;
import com.example.newproject.R;
import com.example.newproject.databinding.FragmentComBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class ComFragment extends Fragment {


    public ComFragment() {

    }

    FragmentComBinding binding;
    ArrayList<Post> list = new ArrayList<>();
    FirebaseDatabase database = FirebaseDatabase.getInstance();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        binding = FragmentComBinding.inflate(inflater, container, false);
        ComAdapter adapter = new ComAdapter(list, getContext());
        binding.recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        binding.recyclerView.setLayoutManager(layoutManager);


        DatabaseReference submissionsRef = database.getReference().child("posts");

        submissionsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    if (postSnapshot.exists()) {
                        Post submission = postSnapshot.getValue(Post.class);
                        if (submission != null) {
                            submission.setUserId(postSnapshot.getKey());
                            list.add(submission);
                        }
                    }
                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle the error
            }
        });




        binding.floatbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), PostActivity.class);
                startActivity(intent);
            }
        });



        return binding.getRoot();
    }
}
package com.example.Components;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.Model.Submission;
import com.example.newproject.R;
import com.example.newproject.databinding.ActivityDetailsViewBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Details_View extends AppCompatActivity {

    ActivityDetailsViewBinding binding;
    ArrayList<Submission> list = new ArrayList<>();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    FirebaseAuth auth  = FirebaseAuth.getInstance();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        CheckAdapter adapter = new CheckAdapter(list,getApplicationContext());
        binding.recyclerViewCheck.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        binding.recyclerViewCheck.setLayoutManager(layoutManager);
        if (auth.getCurrentUser() != null) {
            String uid = auth.getCurrentUser().getUid();
            DatabaseReference submissionsRef = database.getReference().child("submissions").child(uid);

            submissionsRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    list.clear();

                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        Submission submission = dataSnapshot.getValue(Submission.class);
                        submission.setUserId(dataSnapshot.getKey()); // Assuming setUserId method exists in Submission class
                        list.add(submission);
                    }

                    adapter.notifyDataSetChanged();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    // Handle the error
                }
            });

        }

    }
}
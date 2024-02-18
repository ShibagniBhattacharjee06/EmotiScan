package com.example.newproject;
import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.Model.Submission;
import com.example.newproject.databinding.ActivitySubmitViewBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class SubmitView_Activity extends AppCompatActivity {


    ActivitySubmitViewBinding binding;

    FirebaseAuth currentUser = FirebaseAuth.getInstance();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySubmitViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<String> selectedItems = getIntent().getStringArrayListExtra("selectedItems");


        if (selectedItems != null && !selectedItems.isEmpty()) {
            // Display selected items
            StringBuilder displayText = new StringBuilder("Selected items:\n");
            for (String item : selectedItems) {
                displayText.append("- ").append(item).append("\n");
            }
            binding.textView17.setText(displayText.toString());
        } else {
            binding.textView17.setText("No items selected.");
        }

        binding.addSym.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SubmitView_Activity.this,CheckList_Activity.class);
                String mood = getIntent().getStringExtra("data");
                intent.putExtra("data",mood);
                startActivity(intent);
            }
        });



        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userId = currentUser.getUid();
                String fulldetails = binding.multitext.getText().toString();
                String items = binding.textView17.getText().toString();
                String mood = getIntent().getStringExtra("data");
                String currentDate = getCurrentDate();

                    Submission submission = new Submission(mood,fulldetails,items,currentDate);
                    submission.setUserId(userId);
                    String uid = currentUser.getUid();
                    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("submissions").child(uid);
                    databaseReference.push().setValue(submission);
            Intent intent = new Intent(SubmitView_Activity.this,MainActivity.class);
            startActivity(intent);
                finish();
            }
        });
//

    }

    private String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        return sdf.format(new Date());
    }

}
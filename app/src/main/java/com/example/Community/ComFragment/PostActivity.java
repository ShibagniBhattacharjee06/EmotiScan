package com.example.Community.ComFragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.Fragment.CommunityFragment;
import com.example.Fragment.HomeFragment;
import com.example.Model.Post;
import com.example.newproject.MainActivity;
import com.example.newproject.R;
import com.example.newproject.databinding.ActivityPostBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicMarkableReference;

public class PostActivity extends AppCompatActivity {
    ActivityPostBinding binding;

    FirebaseAuth auth  = FirebaseAuth.getInstance();
    DatabaseReference databaseReference;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPostBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        binding.submittedButoon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String postText = binding.postTexted.getText().toString();
                String userId = auth.getUid();


                DocumentReference userDocument = db.collection("users").document(userId);
                userDocument.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()) {
                         String name = documentSnapshot.getString("name");
                            Map<String, Boolean> checkboxValues = new HashMap<>();
                            checkboxValues.put("generalWorry", binding.checkBox2.isChecked());
                            checkboxValues.put("panic", binding.checkBox3.isChecked());
                            checkboxValues.put("perfectionism", binding.checkBox4.isChecked());
                            checkboxValues.put("phobias", binding.checkBox5.isChecked());
                            checkboxValues.put("socialAnxiety", binding.checkBox6.isChecked());

                            Post post = new Post(postText, checkboxValues,userId,name);
                            databaseReference = FirebaseDatabase.getInstance().getReference("posts");
                            databaseReference.push().setValue(post);

                            // Optionally, clear the EditText after submitting
                            binding.postTexted.setText("");

                            Intent intent = new Intent(PostActivity.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            // Document does not exist
                            Log.d("Firestore", "Document does not exist");
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Handle failures
                        Log.e("Firestore", "Error getting document", e);
                    }
                });

            }
        });



    }


}
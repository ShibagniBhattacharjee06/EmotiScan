package com.example.Components;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.newproject.MainActivity;
import com.example.newproject.Profile;
import com.example.newproject.R;
import com.example.newproject.databinding.ActivitySignUpBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Sign_Up_Activity extends AppCompatActivity {

    ActivitySignUpBinding binding;
    FirebaseAuth auth = FirebaseAuth.getInstance();
    FirebaseFirestore firestore = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


       binding.SignRegister.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String email = binding.SignEmail.getText().toString();
               String password = binding.signPassword.getText().toString();
               String name = binding.SignName.getText().toString();
               String country = binding.signCountry.getText().toString();
               auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                   @Override
                   public void onComplete(@NonNull Task<AuthResult> task) {
                       if (task.isSuccessful()){
                           String userId = auth.getCurrentUser().getUid();
                           Map<String, Object> user = new HashMap<>();
                           user.put("name",name);
                           user.put("email", email);
                           user.put("password", password);
                           user.put("country",country);
                           firestore.collection("users")
                                   .document(userId)
                                   .set(user)
                                   .addOnSuccessListener(aVoid -> {
                                       Toast.makeText(Sign_Up_Activity.this, "Users Added Successfully", Toast.LENGTH_SHORT).show();
                                       Intent intent = new Intent(Sign_Up_Activity.this, Profile.class);
                                       intent.putExtra("email",email);
                                       intent.putExtra("name",name);
                                       intent.putExtra("country",country);
                                       intent.putExtra("password",password);
                                       startActivity(intent);
                                       finish();
                                   })
                                   .addOnFailureListener(e -> {
                                       // Error saving user data
                                   });

                       }
                   }
               });
           }
       });

        if (auth.getCurrentUser()!=null){
            Intent intent = new Intent(Sign_Up_Activity.this, Profile.class);
            startActivity(intent);
            finish();
        }




    }
}
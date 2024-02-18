package com.example.newproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import com.example.Components.Sign_Up_Activity;
import com.example.Model.UserProfile;
import com.example.newproject.databinding.ActivityProfileBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class Profile extends AppCompatActivity {


    ActivityProfileBinding binding;
    private FirebaseStorage storage;
    private Uri selectedImageUri;
    private StorageReference storageReference;
    private DatabaseReference databaseReference;
    private FirebaseAuth mAuth;
    private static final int PICK_IMAGE_REQUEST = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();
        databaseReference = FirebaseDatabase.getInstance().getReference("ProfileImage");
        mAuth = FirebaseAuth.getInstance();


        binding.galleryopen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
       openGallery();
            }
        });


        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedImageUri != null) {
                    uploadImage(selectedImageUri);
                }
            }
        });





        if (mAuth.getCurrentUser()!=null){
            Intent intent1 = new Intent(Profile.this, MainActivity.class);
            startActivity(intent1);
            finish();
        }

    }
    private void openGallery() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galleryIntent, PICK_IMAGE_REQUEST);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null) {
            selectedImageUri = data.getData();
            binding.galleryopen.setImageURI(selectedImageUri);
        }
    }
    private void uploadImage(Uri imageUri) {

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseUser user = mAuth.getCurrentUser();
                if (user != null) {
                    Intent intent = getIntent();
                    String email = intent.getStringExtra("email");
                    String password = intent.getStringExtra("password");
                    String name = intent.getStringExtra("name"); // Initialize 'name' variable
                    String country = intent.getStringExtra("country");

                    String userId = user.getUid();
                    DatabaseReference userRef = FirebaseDatabase.getInstance().getReference("Users").child(userId);
                    StorageReference imageRef = storageReference.child("profile_images").child(userId + ".jpg");
                    imageRef.putFile(imageUri)
                            .addOnSuccessListener(taskSnapshot -> imageRef.getDownloadUrl()
                                    .addOnSuccessListener(uri -> {
                                        UserProfile userProfile = new UserProfile();
                                        userProfile.setEmail(user.getEmail());
                                        userProfile.setProfilePicUrl(uri.toString());
                                        userProfile.setCountry(country);
                                        userProfile.setName(name);
                                        userProfile.setPassword(password);
                                        userRef.setValue(userProfile)
                                                .addOnSuccessListener(aVoid -> {
                                                    Toast.makeText(Profile.this, "User Created", Toast.LENGTH_SHORT).show();
                                                   Intent intent1 = new Intent(Profile.this,MainActivity.class);
                                                    intent1.putExtra("profileImageUri", imageUri.toString());
                                                   startActivity(intent1);

                                                })
                                                .addOnFailureListener(e -> {

                                                });
                                    }))
                            .addOnFailureListener(e -> {

                            });
                }
            }
        });
    }

}
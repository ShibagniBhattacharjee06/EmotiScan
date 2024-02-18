package com.example.Fragment;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import com.example.Components.Details_View;
import com.example.Elements.GeneralWorry;
import com.example.Elements.Panic_Activity;
import com.example.Elements.Perfectionism;
import com.example.Elements.Phobias;
import com.example.Elements.SocialAnxiety;
import com.example.Model.UserProfile;
import com.example.Tools.Breathing;
import com.example.Tools.Mindfullness;
import com.example.Tools.Relaxing;
import com.example.newproject.R;
import com.example.newproject.SubmitView_Activity;
import com.example.newproject.databinding.FragmentHomeBinding;
import com.google.common.net.InternetDomainName;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.net.HttpCookie;

public class HomeFragment extends Fragment {

    public HomeFragment() {

    }

    FragmentHomeBinding binding;
    FirebaseAuth auth = FirebaseAuth.getInstance();
    String statusText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);


        binding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                updateImage(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        binding.generalWorry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), GeneralWorry.class);
                startActivity(intent);
            }
        });

        binding.buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), SubmitView_Activity.class);
                intent.putExtra("data", statusText);
                startActivity(intent);
            }
        });

        binding.textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Details_View.class);
                startActivity(intent);
            }
        });

        binding.socialAnxeity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), SocialAnxiety.class);
                startActivity(intent);
            }
        });

        binding.perfect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Perfectionism.class);
                startActivity(intent);
            }
        });

        binding.panic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Panic_Activity.class);
                startActivity(intent);
            }
        });

        binding.breathing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Breathing.class);
                startActivity(intent);
            }
        });

        binding.relax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Relaxing.class);
                startActivity(intent);
            }
        });

        binding.mindfullness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Mindfullness.class);
                startActivity(intent);
            }
        });

        binding.Phobias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Phobias.class);
                startActivity(intent);
            }
        });

        DatabaseReference databaseRef = FirebaseDatabase.getInstance().getReference("Users");
        databaseRef.child(auth.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UserProfile user = snapshot.getValue(UserProfile.class);
                Picasso.get()
                        .load(user.getProfilePicUrl())
                        .into(binding.profile);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        return binding.getRoot();
    }



    private void updateImage(int progress) {
        int imageResourceId;
       statusText = null;
        if (progress < 35) {
            imageResourceId = R.drawable.happy;
            statusText = "Feeling Happy";
        } else if (progress < 65) {
            imageResourceId = R.drawable.happy_sec;
            statusText = "Feeling Neutral";
        } else if (progress <= 100) {
            imageResourceId = R.drawable.sad;
            statusText = "Feeling Sad";
        } else {
            imageResourceId = R.drawable.happy_sec;
        }
        binding.imageView2.setImageResource(imageResourceId);
        binding.textView27.setText(statusText);

    }
}

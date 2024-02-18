package com.example.Tools;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.example.Adapter.YoutubeAdapter;
import com.example.Model.youtube;
import com.example.newproject.R;

import java.util.ArrayList;

public class Breathing extends AppCompatActivity {


   com.example.newproject.databinding.ActivityBreathingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = com.example.newproject.databinding.ActivityBreathingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<youtube> list = new ArrayList<>();

        list.add(new youtube("3 Most Effective Pranayamas","395ZloN4Rr8?si=sCe6E0TSHw24vu6r"));
        list.add(new youtube("4-7-8 Calm Breathing Exercise","LiUnFJ8P4gM?si=fa7CDbl1dG741K7H"));
        list.add(new youtube("3 Yoga Breathing Exercises for Anxiety | Caren Baginski","N9jmO6xwFfs?si=nY86JZrTOlBE378D"));
        list.add(new youtube("3 Deep Breathing Exercises to Reduce Stress & Anxiety","sJ04nsiz_M0?si=L4O9LBQTjbdm5uJl"));
        list.add(new youtube("Neuroscientist: You Will NEVER Feel Stressed Again | Andrew Huberman","u0OBgihk2f8?si=ROWCqHwR6dlvmch6"));

        YoutubeAdapter adapter = new YoutubeAdapter(list,getApplicationContext());
        binding.breathingRecycler.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        binding.breathingRecycler.setLayoutManager(linearLayoutManager);

        adapter.setOnItemClickListener(new YoutubeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String videoUrl) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=" + videoUrl));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    // Open the YouTube app
                    startActivity(intent);
                } else {
                    // If the YouTube app is not installed, open in a web browser
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=" + videoUrl));
                    startActivity(intent);
                }
            }
        });

    }
}
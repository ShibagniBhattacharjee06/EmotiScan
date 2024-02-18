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

public class Mindfullness extends AppCompatActivity {


    com.example.newproject.databinding.ActivityMindfullnessBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = com.example.newproject.databinding.ActivityMindfullnessBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<youtube> list = new ArrayList<>();
        YoutubeAdapter adapter = new YoutubeAdapter(list,getApplicationContext());
        binding.recMind.setAdapter(adapter);

        list.add(new youtube("Short Meditation For Beginners","DulNz2CkoHI?si=qT9dW3LoaKRdqTn3"));
        list.add(new youtube("5-Minute Meditation You Can Do Anywhere","inpok4MKVLM?si=L8bFRtn6m9ukmgsm"));
        list.add(new youtube("Remove all Self Doubts and Insecurities","yirSgDsNfQI?si=FY4wnFGoRmqVu1ML"));
        list.add(new youtube("15 Minute Guided Meditation","z0GtmPnqAd8?si=M_HdzNRmTPeF0hf7"));
        list.add(new youtube("Powerful Guided Meditation for Healing & Letting Go","vtOAnC73xtk?si=ZUVpOT-hWaKg6QtV"));



        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        binding.recMind.setLayoutManager(linearLayoutManager);

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
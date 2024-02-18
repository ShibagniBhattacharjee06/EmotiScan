package com.example.Components;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.newproject.R;
import com.example.newproject.databinding.ActivityNextDetailsViewBinding;

public class NextDetailsView extends AppCompatActivity {


    ActivityNextDetailsViewBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNextDetailsViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        String fulldetails = getIntent().getStringExtra("fulldetails");
        String items = getIntent().getStringExtra("items");
        String mood = getIntent().getStringExtra("mood");
        String date = getIntent().getStringExtra("date");

        binding.dateNest.setText(date);
        binding.fulldetails.setText(fulldetails);
   binding.selItems.setText(items);
   binding.mood.setText(mood);

    }
}
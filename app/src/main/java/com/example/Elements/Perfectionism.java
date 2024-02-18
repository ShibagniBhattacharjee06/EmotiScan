package com.example.Elements;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.Adapter.SocialAdapter;
import com.example.newproject.R;
import com.example.newproject.databinding.ActivityPerfectionismBinding;

public class Perfectionism extends AppCompatActivity {

    ActivityPerfectionismBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPerfectionismBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.viewpager.setAdapter(new com.example.Adapter.Perfectionism(getSupportFragmentManager()));
        binding.tablayout.setupWithViewPager(binding.viewpager);



    }
}
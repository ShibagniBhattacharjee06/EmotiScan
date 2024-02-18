package com.example.Elements;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.Adapter.Phobia_Adapter;
import com.example.Adapter.SocialAdapter;
import com.example.newproject.R;
import com.example.newproject.databinding.ActivityPhobiasBinding;

public class Phobias extends AppCompatActivity {

    ActivityPhobiasBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhobiasBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.viewpager.setAdapter(new Phobia_Adapter(getSupportFragmentManager()));
        binding.tablayout.setupWithViewPager(binding.viewpager);
    }
}
package com.example.Elements;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.Adapter.GeneralAdapter;
import com.example.Adapter.SocialAdapter;
import com.example.newproject.R;
import com.example.newproject.databinding.ActivitySocialAnxietyBinding;

public class SocialAnxiety extends AppCompatActivity {


    ActivitySocialAnxietyBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySocialAnxietyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.viewpager.setAdapter(new SocialAdapter(getSupportFragmentManager()));
        binding.tablayout.setupWithViewPager(binding.viewpager);




    }
}
package com.example.Elements;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.Adapter.PanicAdapter;
import com.example.Adapter.SocialAdapter;
import com.example.newproject.R;
import com.example.newproject.databinding.ActivityPanicBinding;

public class Panic_Activity extends AppCompatActivity {


ActivityPanicBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPanicBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.viewpager.setAdapter(new PanicAdapter(getSupportFragmentManager()));
        binding.tablayout.setupWithViewPager(binding.viewpager);
    }
}
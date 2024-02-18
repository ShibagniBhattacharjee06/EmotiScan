package com.example.newproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.Community.ComFragment.ComAdapter;
import com.example.Fragment.CommunityFragment;
import com.example.Fragment.HelpFragment;
import com.example.Fragment.HomeFragment;
import com.example.newproject.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, new HomeFragment());
        fragmentTransaction.commit();



        binding.bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                if (item.getItemId() == R.id.home_view) {
                    fragmentTransaction.replace(R.id.fragment_container, new HomeFragment());
                    Log.d("MainActivity", "Switching to HomeFragment");
                } else if (item.getItemId() == R.id.community_view) {
                    fragmentTransaction.replace(R.id.fragment_container, new CommunityFragment());
                    Log.d("MainActivity", "Switching to CommunityFragment");
                } else if (item.getItemId() == R.id.help_view) {
                    fragmentTransaction.replace(R.id.fragment_container, new HelpFragment());
                    Log.d("MainActivity", "Switching to HelpFragment");
                } else {
                    Log.d("MainActivity", "Unknown item selected");
                }
                fragmentTransaction.commit();
                return true;
            }
        });







    }
}
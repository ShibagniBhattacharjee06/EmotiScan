package com.example.newproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.newproject.databinding.ActivityCheckListBinding;

import java.util.ArrayList;
import java.util.List;

public class CheckList_Activity extends AppCompatActivity {

    ActivityCheckListBinding binding;
    private List<String> selectedItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCheckListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveAndNavigate();
            }
        });



    }

    private void saveAndNavigate() {

        if (binding.checkOption1.isChecked()){
            selectedItems.add("Racing Heart");
        }
        if (binding.checkOption2.isChecked()){
            selectedItems.add("Rapid breathing");
        }
        if (binding.checkOption3.isChecked()){
            selectedItems.add("Chest tightness");
        }
        if (binding.checkOption4.isChecked()){
            selectedItems.add("Feeling very hot or cold");
        }
        if (binding.checkOption5.isChecked()){
            selectedItems.add("Sweating");
        }
        if (binding.checkOption6.isChecked()){
            selectedItems.add("Dry mouth");
        }
        if (binding.checkOption7.isChecked()){
            selectedItems.add("Lump in throat");
        }
        if (binding.checkOption8.isChecked()){
            selectedItems.add("Upset stomach");
        }
        if (binding.checkOption9.isChecked()){
            selectedItems.add("Nausea");
        }
        if (binding.checkOption10.isChecked()){
            selectedItems.add("Dizzy or lightheaded");
        }

        Intent intent = new Intent(this, SubmitView_Activity.class);
        intent.putStringArrayListExtra("selectedItems", (ArrayList<String>) selectedItems);
        String mood = getIntent().getStringExtra("data");
        intent.putExtra("data", mood);
        startActivity(intent);
        finish();
    }
}
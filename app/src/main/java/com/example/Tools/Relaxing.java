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

public class Relaxing extends AppCompatActivity {

    com.example.newproject.databinding.ActivityRelaxingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = com.example.newproject.databinding.ActivityRelaxingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<youtube> list = new ArrayList<>();

        list.add(new youtube("The Sound of Inner Peace","FFYCoxgoozw?si=8yOd6nYKQMW2m7Wq"));
        list.add(new youtube("Alpha Waves Heal The Whole Body and Spirit, Emotional, Physical, Mental & Spiritual Healing","u3papaX85MA?si=QTMJQU7nVihssk-u"));
        list.add(new youtube("Relaxing Sleep Music + Insomnia - Stress Relief, Relaxing Music, Deep Sleeping Music","bP9gMpl1gyQ?si=A32bl5ncpnns7A_C"));
        list.add(new youtube("Calm Sleepy Jazz Night Music ","live/r5lXNHQI4hc?si=spDIZ777Ea3l54x3"));
        list.add(new youtube("Tibetan Flute Healing Stops Overthinking, Eliminates Stress, Anxiety and Calms the Mind","live/Wi_dQEtX4AQ?si=08MabBU3VzZjXgyX"));

        YoutubeAdapter adapter = new YoutubeAdapter(list,getApplicationContext());
        binding.recRelax.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        binding.recRelax.setLayoutManager(linearLayoutManager);

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
package com.example.Elements.SocialFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newproject.R;
import com.example.newproject.databinding.FragmentS2Binding;


public class SFragment2 extends Fragment {


    public SFragment2() {
        // Required empty public constructor
    }

    FragmentS2Binding binding;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentS2Binding.inflate(inflater,container,false);

        return binding.getRoot();
    }
}
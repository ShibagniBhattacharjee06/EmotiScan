package com.example.Elements.perfectionism;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newproject.R;
import com.example.newproject.databinding.FragmentPer1Binding;


public class PerFragment1 extends Fragment {

    public PerFragment1() {

    }

    FragmentPer1Binding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentPer1Binding.inflate(inflater,container,false);





        return binding.getRoot();
    }
}
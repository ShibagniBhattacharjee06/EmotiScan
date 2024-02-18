package com.example.Elements.Phobiasfolder;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newproject.R;
import com.example.newproject.databinding.FragmentB2Binding;


public class BFragment2 extends Fragment {



    public BFragment2() {

    }

    FragmentB2Binding binding;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentB2Binding.inflate(inflater,container,false);
        return binding.getRoot();

    }
}
package com.example.Elements.GeneralFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newproject.R;
import com.example.newproject.databinding.FragmentFragemnt1Binding;

public class Fragemnt1 extends Fragment {



    public Fragemnt1() {
        // Required empty public constructor
    }

    FragmentFragemnt1Binding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentFragemnt1Binding.inflate(inflater,container,false);



        return binding.getRoot();
    }
}
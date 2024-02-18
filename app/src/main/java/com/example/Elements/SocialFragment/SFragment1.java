package com.example.Elements.SocialFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newproject.R;
import com.example.newproject.databinding.FragmentS1Binding;


public class SFragment1 extends Fragment {


    public SFragment1() {

    }

FragmentS1Binding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
     binding = FragmentS1Binding.inflate(inflater,container,false);


        return binding.getRoot();
    }
}
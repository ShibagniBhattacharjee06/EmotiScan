package com.example.Elements.SocialFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newproject.R;
import com.example.newproject.databinding.Fragment3Binding;


public class SFragment3 extends Fragment {

    public SFragment3() {

    }

   Fragment3Binding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = Fragment3Binding.inflate(inflater,container,false);
        return binding.getRoot();
    }
}
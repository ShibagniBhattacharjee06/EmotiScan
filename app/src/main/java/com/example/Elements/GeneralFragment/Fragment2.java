package com.example.Elements.GeneralFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newproject.R;
import com.example.newproject.databinding.Fragment2Binding;


public class Fragment2 extends Fragment {



    public Fragment2() {
        // Required empty public constructor
    }

    Fragment2Binding binding;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding = Fragment2Binding.inflate(inflater,container,false);
        return binding.getRoot();
    }
}
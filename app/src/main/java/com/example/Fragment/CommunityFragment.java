package com.example.Fragment;

import android.os.Bundle;


import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.Adapter.CommunityAdapter;
import com.example.Adapter.SocialAdapter;
import com.example.newproject.R;
import com.example.newproject.databinding.FragmentCommunityBinding;


public class CommunityFragment extends Fragment {



    public CommunityFragment() {

    }

    FragmentCommunityBinding binding;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentCommunityBinding.inflate(inflater,container,false);



        binding.viewpager.setAdapter(new CommunityAdapter(getChildFragmentManager()));
        binding.tablayout.setupWithViewPager(binding.viewpager);



        return binding.getRoot();
    }
}
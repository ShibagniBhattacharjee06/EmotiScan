package com.example.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.Elements.Phobiasfolder.BFragment1;
import com.example.Elements.Phobiasfolder.BFragment2;
import com.example.Elements.Phobiasfolder.BFragment3;


public class Phobia_Adapter extends FragmentPagerAdapter {
    public Phobia_Adapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new BFragment1();
            case 1:
                return new BFragment2();
            case 2:
                return new BFragment3();
            default:
                return new BFragment1();
        }

}

    @Override
    public int getCount() {
        return 3;
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position==0){
            title = "Intro";
        }
        if (position==1){
            title = "Signs";
        }
        if (position==2){
            title = "Tips";
        }
        return title;
    }
}

package com.example.scrolltab;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
//we are extending Fragment ACtivity so automatcally it works for all other fragments.
//plus it supports all lower level andoid os deviced..all imports must be same type in all the frags

//https://developer.android.com/reference/android/support/v4/view/ViewPager
//viewpager shows one page at a time..viewpager is a view

public class MainActivity extends FragmentActivity {

    ViewPager pagerid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //There are two kinds of tabs - swipe and scroll tab

        pagerid = findViewById(R.id.pagerid);
        FragmentManager fragmentManager = getSupportFragmentManager();
        CustomAdapter adapter = new CustomAdapter(fragmentManager);
        pagerid.setAdapter(adapter);

    }
//extend's import version must be same
    class CustomAdapter extends FragmentStatePagerAdapter
    {

        public CustomAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            //returns the fragmnet position to be shown!
            Fragment fragment = null;
            if(position == 0)
            {
                fragment = new Fragment1();
            }
           else if(position == 1)
            {
                fragment = new Fragment2();
            }
           else if(position == 2)
            {
                fragment = new Fragment3();
            }
            return fragment;
        }

        @Override
        public int getCount() {
            //returns the number of fragments to be shown
            return 3;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            //This works for the pageTabstrip..We use this to set up the title of the tabs


            if(position == 0)
            {
                return "Tab one";
            }
            else if(position == 1)
            {
                return "Tab two";
            }
            else if(position == 2)
            {
                return "Tab three";
            }
            return super.getPageTitle(position);
        }
    }
}

package com.example.shivakanth.classmate;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import static java.security.AccessController.getContext;

public class AVPA extends FragmentPagerAdapter {

    private String title[] = {"Mon", "Tue", "Wed", "Thurs", "Fri"};

    public AVPA(FragmentManager manager) {
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        getContext();
        return AdminTabFrag.getInstance(position);
    }

    @Override
    public int getCount() {
        return title.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}

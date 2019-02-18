package com.example.android.miwok.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.android.miwok.fragments.BaseFragment;
import com.example.android.miwok.fragments.FamilyFragment;
import com.example.android.miwok.fragments.NumbersFragment;

/**
 * Created by A4938 on 25.05.2018.
 */

public class CategoryAdapter extends FragmentPagerAdapter {

    private Fragment[] fragments;

    public CategoryAdapter(FragmentManager fm){
        super(fm);
        this.fragments = new Fragment[2];
        fragments[0]=new NumbersFragment();
        fragments[1]=new FamilyFragment();
    }

    @Override
    public Fragment getItem(int position) {
        //return new NumbersFragment();
        return this.fragments[position];
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public String getPageTitle(int position){
        BaseFragment fragment = (BaseFragment) this.getItem(position);
        return fragment.getViewPagerHeader();
    }
}

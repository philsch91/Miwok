package com.example.android.miwok.fragments;

import android.support.v4.app.Fragment;

/**
 * Created by A4938 on 29.05.2018.
 */

public class BaseFragment extends Fragment {

    protected String viewPagerHeader=this.getClass().getSimpleName();

    public void setViewPagerHeader(String header){
        this.viewPagerHeader=header;
    }

    public String getViewPagerHeader() {
        return this.viewPagerHeader;
    }
}

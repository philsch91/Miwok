package com.example.android.miwok.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.android.miwok.R;
import com.example.android.miwok.adapters.WordAdapter;
import com.example.android.miwok.factories.NumberFactory;
import com.example.android.miwok.models.Word;

import java.util.ArrayList;

/**
 * Created by A4938 on 25.05.2018.
 */

public class NumbersFragment extends BaseFragment {

    WordAdapter adapter;

    public NumbersFragment(){
        this.setViewPagerHeader("Numbers");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_numbers, container, false);

        ArrayList<Word> numbers = NumberFactory.getInstance().getNumbers(this.getActivity());

        this.adapter = new WordAdapter(this.getActivity(),numbers);

        ListView listView = (ListView) rootView.findViewById(R.id.mainListView);
        listView.setAdapter(this.adapter);

        return rootView;
    }

}

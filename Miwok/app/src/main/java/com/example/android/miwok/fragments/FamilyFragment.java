package com.example.android.miwok.fragments;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.android.miwok.R;
import com.example.android.miwok.adapters.WordAdapter;
import com.example.android.miwok.contracts.MiwokContract;
import com.example.android.miwok.factories.FamilyFactory;
import com.example.android.miwok.helpers.MiwokDbHelper;
import com.example.android.miwok.models.Word;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by A4938 on 20.06.2018.
 */

public class FamilyFragment extends BaseFragment {

    WordAdapter adapter;

    public FamilyFragment(){
        this.setViewPagerHeader("Family");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        SQLiteDatabase db = new MiwokDbHelper(this.getActivity()).getReadableDatabase();

        String[] projection = {
                BaseColumns._ID,
                MiwokContract.Category.COLUMN_NAME
        };

        String selection = MiwokContract.Category.COLUMN_NAME + " = ?";
        String[] selectionArgs = { "Family" };

        Cursor cursor = db.query(
                MiwokContract.Category.TABLE_NAME,   // The table to query
                projection,                          // The array of columns to return (pass null to get all)
                selection,                          // The columns for the WHERE clause
                selectionArgs,                      // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                null
        );

        List itemIds = new ArrayList<>();
        while(cursor.moveToNext()) {
            long itemId = cursor.getLong(
                    cursor.getColumnIndexOrThrow(MiwokContract.Category._ID));
            itemIds.add(itemId);
        }
        cursor.close();

        Long categoryId = (Long)itemIds.get(0);

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] familyprojection = {
                //BaseColumns._ID,
                MiwokContract.Word.COLUMN_NAME_MIWOK,
                MiwokContract.Word.COLUMN_NAME_ENGLISH,
                MiwokContract.Word.COLUMN_NAME_CATEGORY
        };

        // Filter results WHERE "title" = 'My Title'
        String familyselection = MiwokContract.Word.COLUMN_NAME_CATEGORY + " = ?";
        String[] familyselectionArgs = { Long.toString(categoryId) };

        Cursor familycursor = db.query(
                MiwokContract.Word.TABLE_NAME,   // The table to query
                familyprojection,             // The array of columns to return (pass null to get all)
                familyselection,              // The columns for the WHERE clause
                familyselectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                null
        );

        //List wordEntries = new ArrayList<>();
        ArrayList<Word> words = new ArrayList<>();
        while(familycursor.moveToNext()) {
            /*
            long itemId = cursor.getLong(
                    cursor.getColumnIndexOrThrow(MiwokContract.Category._ID));*/
            Word word = new Word();
            word.setMiwok(familycursor.getString(0));
            word.setEnglish(familycursor.getString(1));

            words.add(word);
        }
        cursor.close();


        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_numbers, container, false);

        this.adapter = new WordAdapter(this.getActivity(),words);

        ListView listView = (ListView) rootView.findViewById(R.id.mainListView);
        listView.setAdapter(this.adapter);

        return rootView;
    }
}

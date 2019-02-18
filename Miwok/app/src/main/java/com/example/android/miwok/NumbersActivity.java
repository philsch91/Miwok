package com.example.android.miwok;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.android.miwok.adapters.WordAdapter;
import com.example.android.miwok.factories.NumberFactory;
import com.example.android.miwok.models.Word;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    //ArrayAdapter<Object> adapter;
    WordAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        /*
        this.adapter = new ArrayAdapter<String>(this,R.layout.numbers_text_view);
        //this.adapter.add(new Word("test1"));
        //this.adapter.add(new Word("test2"));
        this.adapter.add("test1");
        this.adapter.add("test2");
        this.adapter.add("test3");
        //LinearLayout rootView = (LinearLayout) findViewById(R.id.)
        ListView listView = (ListView) findViewById(R.id.mainListView);
        listView.setAdapter(this.adapter);
        this.adapter.add("test4");
        this.adapter.add("test5");
        this.adapter.add("test6");
        */
        /*
        ArrayList<Word> words = new ArrayList<Word>();
        Word one = new Word("lutti","one");
        //Drawable d = this.getResources().getDrawable(R.drawable.number_one,null);
        //Drawable d = this.getDrawable(R.drawable.number_one);
        //Drawable d = ContextCompat.getDrawable(this,R.drawable.number_one);
        Bitmap icon = BitmapFactory.decodeResource(this.getResources(),R.drawable.number_one);
        //one.setImage(icon);
        one.setBitmap(icon);
        words.add(one);
        words.add(new Word("otiiko","two"));
        words.add(new Word("tolookosu","three"));
        words.add(new Word(getResources().getString(R.string.miwok_four),"four"));
        words.add(new Word(getResources().getString(R.string.miwok_five),"five"));
        words.add(new Word(getResources().getString(R.string.miwok_six),"six"));
        words.add(new Word(getResources().getString(R.string.miwok_seven),"seven"));
        words.add(new Word(getResources().getString(R.string.miwok_eight),"eight"));
        */

        ArrayList<Word> numbers = NumberFactory.getInstance().getNumbers(this);

        this.adapter = new WordAdapter(this,numbers);

        ListView listView = (ListView) findViewById(R.id.mainListView);
        listView.setAdapter(this.adapter);
    }

}

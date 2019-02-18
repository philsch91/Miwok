/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.android.miwok.adapters.CategoryAdapter;
import com.example.android.miwok.factories.FamilyFactory;
import com.example.android.miwok.helpers.MiwokDbHelper;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_viewpager_screen_slide);

        //TextView numbers_text_view = (TextView) findViewById(R.id.numbers);
        //NumbersClickListener numClickListener = new NumbersClickListener();
        //numbers_text_view.setOnClickListener(numClickListener);
        //numbers_text_view.setOnClickListener(numbersClickListener);

        int color = ContextCompat.getColor(this,R.color.primary_dark_color);
        int colorSelected = ContextCompat.getColor(this,R.color.primary_color);

        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setBackgroundColor(color);
        pagerAdapter = new CategoryAdapter(this.getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setBackgroundColor(color);
        tabLayout.setupWithViewPager(viewPager);

        FamilyFactory.deleteDatabaseEntries(this.getApplicationContext());
        FamilyFactory.insertDatabaseEntries(this.getApplicationContext());
        //MiwokDbHelper dbHelper = new MiwokDbHelper(this.getApplicationContext());
        //this.getIntent();
    }

    View.OnClickListener numbersClickListener = new View.OnClickListener() {
        public void onClick(View view){
            //Intent intent = new Intent(getApplicationContext(), NumbersActivity.class);
            Intent intent = new Intent(view.getContext(),NumbersActivity.class);
            //intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        }
    };

    public void openNumbersList(View view){
        Intent intent = new Intent(view.getContext(),NumbersActivity.class);
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }

    @Override
    public void onStart(){
        super.onStart();
    }

}

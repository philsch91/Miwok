package com.example.android.miwok.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.miwok.R;
import com.example.android.miwok.models.Word;

import java.util.ArrayList;

/**
 * Created by A4938 on 14.05.2018.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    public WordAdapter(Context context, ArrayList<Word> words){
        super(context,0,words);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Word word = getItem(position);

        if(convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_word,parent,false);
        }

        TextView tvMiwok = (TextView) convertView.findViewById(R.id.tvMiwok);
        tvMiwok.setText(word.getMiwok());
        TextView tvEnglish = (TextView) convertView.findViewById(R.id.tvEnglish);
        tvEnglish.setText(word.getEnglish());

        /*
        if(word.getBitmap()!=null){
            ImageView imageView = (ImageView) convertView.findViewById(R.id.ivImage);
            imageView.setImageBitmap(word.getBitmap());
        }*/
        if(word.getImagePath()!=0){
            ImageView imageView = (ImageView) convertView.findViewById(R.id.ivImage);
            imageView.setImageResource(word.getImagePath());
        }

        if(word.color!=0){
            //convertView.setBackgroundColor(word.color);
            convertView.setBackgroundResource(word.color);
        }else{
            convertView.setBackgroundResource(R.color.category_numbers);
        }

        return convertView;
    }
}

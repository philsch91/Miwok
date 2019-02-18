package com.example.android.miwok.factories;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.android.miwok.R;
import com.example.android.miwok.models.Word;

import java.util.ArrayList;

/**
 * Created by A4938 on 24.05.2018.
 */

public class NumberFactory {

    private static NumberFactory instance=null;

    private NumberFactory(){}

    public static NumberFactory getInstance() {
        if(NumberFactory.instance == null){
            instance=new NumberFactory();
        }
        return instance;
    }

    public ArrayList<Word> getNumbers(Context context){
        ArrayList<Word> numbers = new ArrayList<Word>();

        Word one = new Word("lutti","one");
        //Drawable d = this.getResources().getDrawable(R.drawable.number_one,null);
        //Drawable d = this.getDrawable(R.drawable.number_one);
        //Drawable d = ContextCompat.getDrawable(this,R.drawable.number_one);
        Bitmap icon = BitmapFactory.decodeResource(context.getResources(), R.drawable.number_one);
        //one.setImage(icon);
        //one.setBitmap(icon);
        one.setImagePath(R.drawable.number_one);
        one.color=R.color.category_colors;
        numbers.add(one);

        Word two = new Word(context.getResources().getString(R.string.miwok_two),"two");
        //two.setBitmap(BitmapFactory.decodeResource(context.getResources(),R.drawable.number_two));
        two.setImagePath(R.drawable.number_two);
        numbers.add(two);

        Word three = new Word(context.getResources().getString(R.string.miwok_three),"three");
        //three.setBitmap(BitmapFactory.decodeResource(context.getResources(),R.drawable.number_two));
        three.setImagePath(R.drawable.number_three);
        numbers.add(three);

        Word four = new Word(context.getResources().getString(R.string.miwok_four),"four");
        //four.setBitmap(BitmapFactory.decodeResource(context.getResources(),R.drawable.number_four));
        four.setImagePath(R.drawable.number_four);
        numbers.add(four);

        Word five = new Word(context.getResources().getString(R.string.miwok_five),"five");
        //five.setBitmap(BitmapFactory.decodeResource(context.getResources(),R.drawable.number_five));
        five.setImagePath(R.drawable.number_five);
        numbers.add(five);

        Word six = new Word(context.getResources().getString(R.string.miwok_six),"six");
        //six.setBitmap(BitmapFactory.decodeResource(context.getResources(),R.drawable.number_six));
        six.setImagePath(R.drawable.number_six);
        numbers.add(six);

        Word seven = new Word(context.getResources().getString(R.string.miwok_seven),"seven");
        //seven.setBitmap(BitmapFactory.decodeResource(context.getResources(),R.drawable.number_seven));
        seven.setImagePath(R.drawable.number_seven);
        numbers.add(seven);

        Word eight = new Word(context.getResources().getString(R.string.miwok_eight),"eight");
        //eight.setBitmap(BitmapFactory.decodeResource(context.getResources(),R.drawable.number_eight));
        eight.setImagePath(R.drawable.number_eight);
        numbers.add(eight);

        Word nine = new Word(context.getResources().getString(R.string.miwok_nine),"nine");
        //nine.setBitmap(BitmapFactory.decodeResource(context.getResources(),R.drawable.number_nine));
        nine.setImagePath(R.drawable.number_nine);
        numbers.add(nine);

        Word ten = new Word(context.getResources().getString(R.string.miwok_ten),"ten");
        //ten.setBitmap(BitmapFactory.decodeResource(context.getResources(),R.drawable.number_ten));
        ten.setImagePath(R.drawable.number_ten);
        numbers.add(ten);

        return numbers;
    }
}

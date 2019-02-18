package com.example.android.miwok.factories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import com.example.android.miwok.contracts.MiwokContract;
import com.example.android.miwok.helpers.MiwokDbHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by A4938 on 20.06.2018.
 */

public class FamilyFactory {

    public static void deleteDatabaseEntries(Context context){
        MiwokDbHelper miwokDbHelper = new MiwokDbHelper(context);
        SQLiteDatabase db = miwokDbHelper.getWritableDatabase();
        db.delete(MiwokContract.Category.TABLE_NAME,null,null);
        db.delete(MiwokContract.Word.TABLE_NAME,null,null);
    }

    public static void insertDatabaseEntries(Context context){

        MiwokDbHelper miwokDbHelper = new MiwokDbHelper(context);

        SQLiteDatabase db = miwokDbHelper.getWritableDatabase();

        ContentValues catValues = new ContentValues();
        catValues.put(MiwokContract.Category.COLUMN_NAME,"Family");
        db.insert(MiwokContract.Category.TABLE_NAME,null,catValues);

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

        ArrayList<ContentValues> values = new ArrayList<>();

        ContentValues father = new ContentValues();
        father.put(MiwokContract.Word.COLUMN_NAME_MIWOK,"epe");
        father.put(MiwokContract.Word.COLUMN_NAME_ENGLISH,"father");
        father.put(MiwokContract.Word.COLUMN_NAME_CATEGORY,categoryId);
        values.add(father);

        ContentValues mother = new ContentValues();
        mother.put(MiwokContract.Word.COLUMN_NAME_MIWOK,"eta");
        mother.put(MiwokContract.Word.COLUMN_NAME_ENGLISH,"mother");
        mother.put(MiwokContract.Word.COLUMN_NAME_CATEGORY,categoryId);
        values.add(mother);

        ContentValues son = new ContentValues();
        son.put(MiwokContract.Word.COLUMN_NAME_MIWOK,"angsi");
        son.put(MiwokContract.Word.COLUMN_NAME_ENGLISH,"son");
        son.put(MiwokContract.Word.COLUMN_NAME_CATEGORY,categoryId);
        values.add(son);

        ContentValues daughter = new ContentValues();
        daughter.put(MiwokContract.Word.COLUMN_NAME_MIWOK,"tune");
        daughter.put(MiwokContract.Word.COLUMN_NAME_ENGLISH,"daughter");
        daughter.put(MiwokContract.Word.COLUMN_NAME_CATEGORY,categoryId);
        values.add(daughter);

        ContentValues olderBrother = new ContentValues();
        olderBrother.put(MiwokContract.Word.COLUMN_NAME_MIWOK,"taachi");
        olderBrother.put(MiwokContract.Word.COLUMN_NAME_ENGLISH,"older brother");
        olderBrother.put(MiwokContract.Word.COLUMN_NAME_CATEGORY,categoryId);
        values.add(olderBrother);

        ContentValues youngerBrother = new ContentValues();
        youngerBrother.put(MiwokContract.Word.COLUMN_NAME_MIWOK,"chalitti");
        youngerBrother.put(MiwokContract.Word.COLUMN_NAME_ENGLISH,"younger brother");
        youngerBrother.put(MiwokContract.Word.COLUMN_NAME_CATEGORY,categoryId);
        values.add(youngerBrother);

        for(ContentValues v : values){
            db.insert(MiwokContract.Word.TABLE_NAME,null,v);
        }
    }
}

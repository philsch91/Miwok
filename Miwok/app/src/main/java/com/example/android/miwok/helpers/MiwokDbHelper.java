package com.example.android.miwok.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.miwok.contracts.MiwokContract;

/**
 * Created by A4938 on 20.06.2018.
 */

public class MiwokDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME = "Miwok.db";

    private static final String SQL_CREATE_CATEGORIES =
            "CREATE TABLE " + MiwokContract.Category.TABLE_NAME + " (" +
                    MiwokContract.Category._ID + " INTEGER PRIMARY KEY," +
                    MiwokContract.Category.COLUMN_NAME + " TEXT);";

    private static final String SQL_DELETE_CATEGORIES =
            "DROP TABLE IF EXISTS " + MiwokContract.Category.TABLE_NAME;

    private static final String SQL_CREATE_WORDS =
            "CREATE TABLE " + MiwokContract.Word.TABLE_NAME + " (" +
                    MiwokContract.Word._ID + "INTEGER PRIMARY KEY," +
                    MiwokContract.Word.COLUMN_NAME_MIWOK + " TEXT," +
                    MiwokContract.Word.COLUMN_NAME_ENGLISH + " TEXT," +
                    MiwokContract.Word.COLUMN_NAME_CATEGORY + " INTEGER, FOREIGN KEY (" +
                    MiwokContract.Word.COLUMN_NAME_CATEGORY +") REFERENCES " +
                    MiwokContract.Category.TABLE_NAME + "(" + MiwokContract.Category._ID + "));";

    private static final String SQL_DELETE_WORDS =
            "DROP TABLE IF EXISTS " + MiwokContract.Word.TABLE_NAME;


    public MiwokDbHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL(SQL_CREATE_CATEGORIES);
        db.execSQL(SQL_CREATE_WORDS);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        //db.execSQL("");
        //onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion){
        onUpgrade(db,oldVersion,newVersion);
    }
}

package com.example.android.miwok.contracts;

import android.provider.BaseColumns;

/**
 * Created by A4938 on 20.06.2018.
 */

public final class MiwokContract {

    private MiwokContract(){}

    public static class Category implements BaseColumns {
        public static final String TABLE_NAME = "Category";
        public static final String COLUMN_NAME = "Name";
        //public static final String COLUMN_NAME = "Category";
    }

    public static class Word implements BaseColumns {
        public static final String TABLE_NAME = "Word";
        public static final String COLUMN_NAME_MIWOK = "Miwok";
        public static final String COLUMN_NAME_ENGLISH = "English";
        public static final String COLUMN_NAME_CATEGORY = "Category";
    }
}

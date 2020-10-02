package com.example.sanka2.databasesank;

import android.provider.BaseColumns;

public class paper {

    private paper() {
    }

    public static class Users1 implements BaseColumns {
        public static final String TABLE_NAME = "UserInfopaper";
        public static final String COLUMN_1 = "paperID";
        public static final String COLUMN_2 = "Paperlink";
    }
}

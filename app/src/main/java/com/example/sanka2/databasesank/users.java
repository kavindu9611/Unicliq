package com.example.sanka2.databasesank;

import android.provider.BaseColumns;

public class users {
    private users() {
    }

    /* Inner class that defines the table contents */
    public static class Users implements BaseColumns {
        public static final String TABLE_NAME = "UserInfo";
        public static final String COLUMN_1 = "NoticeID";
        public static final String COLUMN_2 = "Notice";
    }
}
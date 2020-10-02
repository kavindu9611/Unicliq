package com.example.sanka2.databasesank;

import android.provider.BaseColumns;

public class course {

    private course() {
    }

    public static class Users2 implements BaseColumns {
        public static final String TABLE_NAME = "UserInfopaper";
        public static final String COLUMN_1 = "courseID";
        public static final String COLUMN_2 = "CourseName";
        public static final String COLUMN_3 = "Duration";
        public static final String COLUMN_4 = "coursefree";
        public static final String COLUMN_5 = "enterrequre";
    }
}

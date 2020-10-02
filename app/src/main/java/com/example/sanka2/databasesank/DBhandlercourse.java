package com.example.sanka2.databasesank;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.List;

public class DBhandlercourse extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "dataase3.db";

    public DBhandlercourse(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }


    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + course.Users2.TABLE_NAME + " (" +
                    course.Users2._ID + " INTEGER PRIMARY KEY," +
                    course.Users2.COLUMN_1 + " TEXT," +
                    course.Users2.COLUMN_2 + " TEXT," +
                    course.Users2.COLUMN_3 + " TEXT," +
                    course.Users2.COLUMN_4 + " TEXT," +
                    course.Users2.COLUMN_5 + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + course.Users2.TABLE_NAME;

    public long addInfo (String courseID, String courseName,String Duration,String cofree,String entire ){
        // Gets the data repository in write mode
        SQLiteDatabase db = getWritableDatabase();


        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(course.Users2.COLUMN_1, courseID);
        values.put(course.Users2.COLUMN_2, courseName);
        values.put(course.Users2.COLUMN_3, Duration);
        values.put(course.Users2.COLUMN_4, cofree);
        values.put(course.Users2.COLUMN_5, entire);




        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(course.Users2.TABLE_NAME, null, values);

        return newRowId;

    }

    public Boolean updateInfo (String courseID, String courseName,String Duration,String cofree,String entire){


        SQLiteDatabase db = getWritableDatabase();

        // New value for one column
        String title = "MyNewTitle";
        ContentValues values = new ContentValues();
        values.put(course.Users2.COLUMN_1, courseID);
        values.put(course.Users2.COLUMN_2, courseName);
        values.put(course.Users2.COLUMN_3, Duration);
        values.put(course.Users2.COLUMN_4, cofree);
        values.put(course.Users2.COLUMN_5, entire);



        // Which row to update, based on the title
        String selection = course.Users2.COLUMN_1 + " LIKE ?";
        String[] selectionArgs = { courseID };

        int count = db.update(
                course.Users2.TABLE_NAME,
                values,
                selection,
                selectionArgs);

        if (count >= 1){
            return true;
        }
        else
        {
            return false;
        }
    }

    public void deleteInfo(String courseID){

        SQLiteDatabase db = getWritableDatabase();

        // Define 'where' part of query.
        String selection = course.Users2.COLUMN_1 + " LIKE ?";
        // Specify arguments in placeholder order.
        String[] selectionArgs = { courseID };
        // Issue SQL statement.
        int deletedRows = db.delete(course.Users2.TABLE_NAME, selection, selectionArgs);
    }


    public List readAllInfo(){

        String username = "avinash";
        SQLiteDatabase db = getReadableDatabase();

// Define a projection that specifies which columns from the database
// you will actually use after this query.
        String[] projection = {
                BaseColumns._ID,
                course.Users2.COLUMN_1,
                course.Users2.COLUMN_2,
                course.Users2.COLUMN_3,
                course.Users2.COLUMN_4,
                course.Users2.COLUMN_5,

        };

// Filter results WHERE "title" = 'My Title'
        String selection = course.Users2.COLUMN_1 + " = ?";
        String[] selectionArgs = { username };

// How you want the results sorted in the resulting Cursor
        String sortOrder = course.Users2.COLUMN_1 + " ASC";

        Cursor cursor = db.query(
                course.Users2.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                null,             // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );
        List usernames = new ArrayList<>();
        while(cursor.moveToNext()) {
            String user = cursor.getString(cursor.getColumnIndexOrThrow(course.Users2.COLUMN_1));
            usernames.add(user);
        }
        cursor.close();
        return usernames;

    }

    public List readAllInfo(String courseID){


        SQLiteDatabase db = getReadableDatabase();

// Define a projection that specifies which columns from the database
// you will actually use after this query.
        String[] projection = {
                BaseColumns._ID,
                course.Users2.COLUMN_1,
                course.Users2.COLUMN_2,
                course.Users2.COLUMN_3,
                course.Users2.COLUMN_4,
                course.Users2.COLUMN_5,

        };

// Filter results WHERE "title" = 'My Title'
        String selection = course.Users2.COLUMN_1 + " LIKE ?";
        String[] selectionArgs = { courseID};

// How you want the results sorted in the resulting Cursor
        String sortOrder =
                course.Users2.COLUMN_1 + " ASC";

        Cursor cursor = db.query(
                course.Users2.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,             // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );

        List userInfocourse = new ArrayList<>();
        while(cursor.moveToNext()) {
            String courseiD = cursor.getString(cursor.getColumnIndexOrThrow(course.Users2.COLUMN_1));
            String courseName = cursor.getString(cursor.getColumnIndexOrThrow(course.Users2.COLUMN_2));
            String duration = cursor.getString(cursor.getColumnIndexOrThrow(course.Users2.COLUMN_3));
            String coursefree = cursor.getString(cursor.getColumnIndexOrThrow(course.Users2.COLUMN_4));
            String educat = cursor.getString(cursor.getColumnIndexOrThrow(course.Users2.COLUMN_5));


            userInfocourse.add(courseiD);//0
            userInfocourse.add(courseName);//1
            userInfocourse.add(duration);
            userInfocourse.add(coursefree);
            userInfocourse.add(educat);


        }
        cursor.close();
        return userInfocourse;

    }
}




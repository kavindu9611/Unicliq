package com.example.sanka2.databasesank;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.List;



    public class DBhandlers extends SQLiteOpenHelper {
        // If you change the database schema, you must increment the database version.
        public static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "database1.db";

        public DBhandlers(Context context) {
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
            "CREATE TABLE " + users.Users.TABLE_NAME + " (" +
                    users.Users._ID + " INTEGER PRIMARY KEY," +
                    users.Users.COLUMN_1 + " TEXT," +
                    users.Users.COLUMN_2 + " TEXT)";
    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + users.Users.TABLE_NAME;

    public long addInfo (String noteId, String note){
        // Gets the data repository in write mode
        SQLiteDatabase db = getWritableDatabase();


        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(users.Users.COLUMN_1, noteId);
        values.put(users.Users.COLUMN_2, note);




        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(users.Users.TABLE_NAME, null, values);

        return newRowId;

    }

    public Boolean updateInfo (String noticeID, String Notice){


        SQLiteDatabase db = getWritableDatabase();

        // New value for one column
        String title = "MyNewTitle";
        ContentValues values = new ContentValues();
        values.put(users.Users.COLUMN_1, noticeID);
        values.put(users.Users.COLUMN_2, Notice);



        // Which row to update, based on the title
        String selection = users.Users.COLUMN_1 + " LIKE ?";
        String[] selectionArgs = { noticeID };

        int count = db.update(
                users.Users.TABLE_NAME,
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

    public void deleteInfo(String username){

        SQLiteDatabase db = getWritableDatabase();

        // Define 'where' part of query.
        String selection = users.Users.COLUMN_1 + " LIKE ?";
        // Specify arguments in placeholder order.
        String[] selectionArgs = { username };
        // Issue SQL statement.
        int deletedRows = db.delete(users.Users.TABLE_NAME, selection, selectionArgs);
    }


    public List readAllInfo(){

        String username = "avinash";
        SQLiteDatabase db = getReadableDatabase();

// Define a projection that specifies which columns from the database
// you will actually use after this query.
        String[] projection = {
                BaseColumns._ID,
                users.Users.COLUMN_1,
                users.Users.COLUMN_2,

        };

// Filter results WHERE "title" = 'My Title'
        String selection = users.Users.COLUMN_1 + " = ?";
        String[] selectionArgs = { username };

// How you want the results sorted in the resulting Cursor
        String sortOrder = users.Users.COLUMN_1 + " ASC";

        Cursor cursor = db.query(
                users.Users.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                null,             // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );
        List usernames = new ArrayList<>();
        while(cursor.moveToNext()) {
            String user = cursor.getString(cursor.getColumnIndexOrThrow(users.Users.COLUMN_1));
            usernames.add(user);
        }
        cursor.close();
        return usernames;

    }

    public List readAllInfo(String username){


        SQLiteDatabase db = getReadableDatabase();

// Define a projection that specifies which columns from the database
// you will actually use after this query.
        String[] projection = {
                BaseColumns._ID,
                users.Users.COLUMN_1,
                users.Users.COLUMN_2,

        };

// Filter results WHERE "title" = 'My Title'
        String selection = users.Users.COLUMN_1 + " LIKE ?";
        String[] selectionArgs = { username};

// How you want the results sorted in the resulting Cursor
        String sortOrder =
                users.Users.COLUMN_1 + " ASC";

        Cursor cursor = db.query(
                users.Users.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,             // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );

        List userInfo = new ArrayList<>();
        while(cursor.moveToNext()) {
            String noteID = cursor.getString(cursor.getColumnIndexOrThrow(users.Users.COLUMN_1));
            String note = cursor.getString(cursor.getColumnIndexOrThrow(users.Users.COLUMN_2));


            userInfo.add(noteID);//0
            userInfo.add(note);//1


        }
        cursor.close();
        return userInfo;

    }
}

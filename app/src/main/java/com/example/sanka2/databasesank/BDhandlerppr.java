package com.example.sanka2.databasesank;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.List;

public class BDhandlerppr extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "dataase2.db";

    public BDhandlerppr(Context context) {
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
            "CREATE TABLE " + paper.Users1.TABLE_NAME + " (" +
                    paper.Users1._ID + " INTEGER PRIMARY KEY," +
                    paper.Users1.COLUMN_1 + " TEXT," +
                    paper.Users1.COLUMN_2 + " TEXT)";
    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + paper.Users1.TABLE_NAME;

    public long addInfo (String paperID, String paperLink){
        // Gets the data repository in write mode
        SQLiteDatabase db = getWritableDatabase();


        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(paper.Users1.COLUMN_1, paperID);
        values.put(paper.Users1.COLUMN_2, paperLink);




        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(paper.Users1.TABLE_NAME, null, values);

        return newRowId;

    }

    public Boolean updateInfo (String paperID, String paperLink){


        SQLiteDatabase db = getWritableDatabase();

        // New value for one column
        String title = "MyNewTitle";
        ContentValues values = new ContentValues();
        values.put(paper.Users1.COLUMN_1, paperID);
        values.put(paper.Users1.COLUMN_2, paperLink);



        // Which row to update, based on the title
        String selection = paper.Users1.COLUMN_1 + " LIKE ?";
        String[] selectionArgs = { paperID };

        int count = db.update(
                paper.Users1.TABLE_NAME,
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

    public void deleteInfo(String paperID){

        SQLiteDatabase db = getWritableDatabase();

        // Define 'where' part of query.
        String selection = paper.Users1.COLUMN_1 + " LIKE ?";
        // Specify arguments in placeholder order.
        String[] selectionArgs = { paperID };
        // Issue SQL statement.
        int deletedRows = db.delete(paper.Users1.TABLE_NAME, selection, selectionArgs);
    }


    public List readAllInfo(){

        String username = "avinash";
        SQLiteDatabase db = getReadableDatabase();

// Define a projection that specifies which columns from the database
// you will actually use after this query.
        String[] projection = {
                BaseColumns._ID,
                paper.Users1.COLUMN_1,
                paper.Users1.COLUMN_2,

        };

// Filter results WHERE "title" = 'My Title'
        String selection = paper.Users1.COLUMN_1 + " = ?";
        String[] selectionArgs = { username };

// How you want the results sorted in the resulting Cursor
        String sortOrder = paper.Users1.COLUMN_1 + " ASC";

        Cursor cursor = db.query(
                paper.Users1.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                null,             // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );
        List usernames = new ArrayList<>();
        while(cursor.moveToNext()) {
            String user = cursor.getString(cursor.getColumnIndexOrThrow(paper.Users1.COLUMN_1));
            usernames.add(user);
        }
        cursor.close();
        return usernames;

    }

    public List readAllInfo(String paperID){


        SQLiteDatabase db = getReadableDatabase();

// Define a projection that specifies which columns from the database
// you will actually use after this query.
        String[] projection = {
                BaseColumns._ID,
                paper.Users1.COLUMN_1,
                paper.Users1.COLUMN_2,

        };

// Filter results WHERE "title" = 'My Title'
        String selection = paper.Users1.COLUMN_1 + " LIKE ?";
        String[] selectionArgs = { paperID};

// How you want the results sorted in the resulting Cursor
        String sortOrder =
                paper.Users1.COLUMN_1 + " ASC";

        Cursor cursor = db.query(
                paper.Users1.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,             // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );

        List userInfoppr = new ArrayList<>();
        while(cursor.moveToNext()) {
            String paperiD = cursor.getString(cursor.getColumnIndexOrThrow(paper.Users1.COLUMN_1));
            String paperLink = cursor.getString(cursor.getColumnIndexOrThrow(paper.Users1.COLUMN_2));


            userInfoppr.add(paperiD);//0
            userInfoppr.add(paperLink);//1


        }
        cursor.close();
        return userInfoppr;

    }
}



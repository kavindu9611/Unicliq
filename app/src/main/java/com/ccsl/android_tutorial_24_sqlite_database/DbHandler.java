package com.ccsl.android_tutorial_24_sqlite_database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

public class DbHandler extends SQLiteOpenHelper {

    private static final int VERSION = 2;
    private static final String DB_NAME = "todo";
    private static final String TABLE_NAME = "todo";


    private static final String ID = "id";
    private static final String TITLE = "title";
    private static final String VENUE= "Venue";
    private static final String DESCRIPTION = "description";
    private static final String STARTED = "started";
    private static final String FINISHED = "finished";

    public DbHandler(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String TABLE_CREATE_QUERY = "CREATE TABLE "+TABLE_NAME+" " +
                "("
                +ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +TITLE + " TEXT,"
                +VENUE + " TEXT,"
                +DESCRIPTION + " TEXT,"
                +STARTED+ " TEXT,"
                +FINISHED+" TEXT" +
                ");";



        db.execSQL(TABLE_CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS "+ TABLE_NAME;
        // Drop older table if existed
        db.execSQL(DROP_TABLE_QUERY);
        // Create tables again
        onCreate(db);
    }



    public void addToDo(ToDo toDo){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(TITLE,toDo.getTitle());
        contentValues.put(VENUE, toDo.getVenue());
        contentValues.put(DESCRIPTION, toDo.getDescription());
        contentValues.put(STARTED,toDo.getStarted());
        contentValues.put(FINISHED,toDo.getFinished());


        sqLiteDatabase.insert(TABLE_NAME,null,contentValues);

        sqLiteDatabase.close();
    }


    public int countToDo(){
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM "+ TABLE_NAME;

        Cursor cursor = db.rawQuery(query,null);
        return cursor.getCount();
    }


    public List<ToDo> getAllToDos(){

        List<ToDo> toDos = new ArrayList();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM "+TABLE_NAME;

        Cursor cursor = db.rawQuery(query,null);

        if(cursor.moveToFirst()){
            do {

                ToDo toDo = new ToDo();

                toDo.setId(cursor.getInt(0));
                toDo.setTitle(cursor.getString(1));
                toDo.setVenue(cursor.getString(2));
                toDo.setDescription(cursor.getString(3));
                toDo.setStarted(cursor.getLong(4));
                toDo.setFinished(cursor.getLong(5));

                //toDos [obj,objs,asas,asa]
                toDos.add(toDo);
            }while (cursor.moveToNext());
        }
        return toDos;
    }


    public void deleteToDo(int id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME,"id =?",new String[]{String.valueOf(id)});
        db.close();
    }

    public ToDo getSingleToDo(int id){
        SQLiteDatabase db = getWritableDatabase();

       Cursor cursor = db.query(TABLE_NAME,new String[]{ID,TITLE,VENUE,DESCRIPTION,STARTED, FINISHED},
                ID + "= ?",new String[]{String.valueOf(id)}
                ,null,null,null);

       ToDo toDo;
       if(cursor != null){
            cursor.moveToFirst();
         toDo = new ToDo(
                 cursor.getInt(0),
                 cursor.getString(1),
                 cursor.getString(2),
                 cursor.getString(3),
                 cursor.getLong(4),
                 cursor.getLong(5)
         );
         return toDo;
       }
       return null;
    }


    public int updateSingleToDo(ToDo toDo){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(TITLE,toDo.getTitle());
        contentValues.put(VENUE, toDo.getVenue());
        contentValues.put(DESCRIPTION, toDo.getDescription());
        contentValues.put(STARTED,toDo.getStarted());
        contentValues.put(FINISHED,toDo.getFinished());

        int status = db.update(TABLE_NAME,contentValues,ID +" =?",
                new String[]{String.valueOf(toDo.getId())});

        db.close();
        return status;
    }
}

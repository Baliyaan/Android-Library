package com.baliyaan.android.library.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Pulkit on 31-Jan-16.
 */
public class SQLiteHelper extends SQLiteOpenHelper{
    private static SQLiteHelper mInstance;
    private SQLiteDatabase mDB;

    private SQLiteHelper(Context context, String dbName, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, dbName, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean IsTableExists(String tableName)
    {
        SQLiteDatabase sqLiteDatabase = getDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("select DISTINCT tbl_name from sqlite_master where tbl_name = '"+tableName+"'", null);
        if(cursor!=null) {
            if(cursor.getCount()>0) {
                cursor.close();
                return true;
            }
            cursor.close();
        }

        return false;
    }

    public static synchronized SQLiteHelper getInstance(Context context,String dbName, SQLiteDatabase.CursorFactory factory, int version) {

        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (mInstance == null) {
            mInstance = new SQLiteHelper(context, dbName, factory, version);
        }
        return mInstance;
    }

    public SQLiteDatabase getDatabase()
    {
        if(mDB == null)
            mDB = getWritableDatabase();
        return mDB;
    }
}

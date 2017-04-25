package com.quan.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator PC on 25-Apr-17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    static String mDatabaseName = "kimdung.sqlite"; // Tên Database
    static int mDatabaseVersion = 3; // Phiên bản Database

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, mDatabaseName, factory, mDatabaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

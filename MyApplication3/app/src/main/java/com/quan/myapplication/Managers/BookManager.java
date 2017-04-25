package com.quan.myapplication.Managers;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.quan.myapplication.Entities.Book;

import java.util.ArrayList;

/**
 * Created by Administrator PC on 25-Apr-17.
 */

public class BookManager {
    DatabaseHelper mHelper;
    SQLiteDatabase mDatabase;

    public BookManager(Context context) {
        mHelper = new DatabaseHelper(context, null, null, 0);
        mDatabase = mHelper.getWritableDatabase();
    }

    public void closeConnection() {
        if (mDatabase != null) {
            mDatabase.close();
        }
    }

    public ArrayList<Book> getAllShopping() {
        String sql = "SELECT * FROM kimdung";
        Cursor cur = mDatabase.rawQuery(sql, null);
        ArrayList<Book> lstData = new ArrayList<Book>();
        while (cur.moveToNext()) {
            Book book = new Book();
            book.setBookID(cur.getInt(0));
            book.setBookName(cur.getString(1));
            book.setAuthorID(cur.getInt(2));
            book.setImagePath(cur.getString(3));
            book.setBookDescription(cur.getString(4));

            lstData.add(book);
        }
        return lstData;
    }

}

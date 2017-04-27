package com.quan.myapplication.Managers;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.quan.myapplication.Entities.Book;
import com.quan.myapplication.Entities.Chapter;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Administrator PC on 25-Apr-17.
 */

public class BookManager {
    DatabaseHelper mHelper;
    SQLiteDatabase mDatabase;

    public BookManager(Context context) throws IOException {
        mHelper = new DatabaseHelper(context);
        mHelper.createDataBase();
        mDatabase = mHelper.getWritableDatabase();
    }

    public void closeConnection() {
        if (mDatabase != null) {
            mDatabase.close();
        }
    }

    public ArrayList<Book> getAllBook() {
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

    public ArrayList<Chapter> getAllChapter(Integer bookID)
    {
        String sql = "SELECT deID, deName FROM st_kimdung where stID = ?";
        String[] params = {bookID.toString()};
        Cursor cur = mDatabase.rawQuery(sql, params);
        ArrayList<Chapter> lstData = new ArrayList<Chapter>();
        while (cur.moveToNext()) {
            Chapter chapter = new Chapter();
            chapter.setChapterID(cur.getInt(0));
            chapter.setChapterName(cur.getString(1));

            lstData.add(chapter);
        }
        return lstData;
    }

    public Chapter getChapter(Integer chapterID)
    {
        String sql = "SELECT * FROM st_kimdung where deID = ?";
        Chapter chapter = new Chapter();
        String[] params = {chapterID.toString()};
        Cursor cur = mDatabase.rawQuery(sql, params);
        ArrayList<Chapter> lstData = new ArrayList<Chapter>();
        while (cur.moveToNext()) {
            chapter.setChapterID(cur.getInt(0));
            chapter.setChapterName(cur.getString(1));
            chapter.setSource(cur.getString(2));
            chapter.setChapterContent(cur.getString(3));
            chapter.setBookID(cur.getInt(4));
        }

        return chapter;
    }

}

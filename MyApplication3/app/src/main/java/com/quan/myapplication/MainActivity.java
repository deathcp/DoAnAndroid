package com.quan.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.quan.myapplication.Adapters.BookAdapter;
import com.quan.myapplication.Managers.BookManager;
import com.quan.myapplication.Managers.DatabaseHelper;

public class MainActivity extends AppCompatActivity {
    ListView mList;
    BookManager bookManager = new BookManager(MainActivity.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mList = (ListView) findViewById(R.id.lstBook);
        BookAdapter bookAdapter = new BookAdapter(MainActivity.this, R.layout.book_row, bookManager.getAllBook());

        mList.setAdapter(bookAdapter);

    }
}

package com.quan.myapplication.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.quan.myapplication.Adapters.BookAdapter;
import com.quan.myapplication.Entities.Book;
import com.quan.myapplication.Managers.BookManager;
import com.quan.myapplication.R;

import java.io.IOException;

public class BookActivity extends AppCompatActivity {
    ListView mList;
    BookManager bookManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            bookManager = new BookManager(BookActivity.this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        mList = (ListView) findViewById(R.id.lstBook);
        final BookAdapter bookAdapter = new BookAdapter(BookActivity.this, R.layout.book_row, bookManager.getAllBook());

        mList.setAdapter(bookAdapter);

        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Book book = (Book) bookAdapter.getItem(position);
                Intent intent = new Intent(BookActivity.this, ChapterActivity.class);
                intent.putExtra("book", book);
                startActivity(intent);
            }
        });
    }
}

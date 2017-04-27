package com.quan.myapplication.Activities;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.quan.myapplication.Entities.Book;
import com.quan.myapplication.Entities.Chapter;
import com.quan.myapplication.Managers.BookManager;
import com.quan.myapplication.R;

import java.io.IOException;
import java.util.ArrayList;

public class ChapterActivity extends AppCompatActivity {
    private BookManager bookManager;
    private ListView mList;
    private Intent myIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);

        try {
            bookManager = new BookManager(ChapterActivity.this);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(myIntent == null)
        {
            myIntent = getIntent();
        }
        ActionBar actionBar = getSupportActionBar();
        actionBar.setCustomView(R.layout.menu_search);
        // Lấy widget EditText
        EditText search = (EditText) actionBar.getCustomView().findViewById(
                R.id.searchfield);
        search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId,
                                          KeyEvent event) {
                Toast.makeText(ChapterActivity.this, "Search triggered",
                        Toast.LENGTH_LONG).show();
                return false;
            }
        });
        // Cài đặt chế độ hiển thị
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM
                | ActionBar.DISPLAY_SHOW_HOME);
        ImageButton imgSearch = (ImageButton)
                actionBar.getCustomView().findViewById(R.id.imageButton);

        Book book = (Book) myIntent.getSerializableExtra("book");
        //Set book name
        setTitle(book.getBookName());
        TextView bookName = (TextView) findViewById(R.id.detailBookName);
        bookName.setText(book.getBookName());
        //Set book image
        ImageView imageView = (ImageView) findViewById(R.id.detailBookImg);
        int drawID = getResources().getIdentifier(book.getImagePath(),"drawable",getPackageName());
        imageView.setImageResource(drawID);

        final ArrayList<Chapter> lstChapters = bookManager.getAllChapter(book.getBookID());
        ArrayAdapter<Chapter> chapterArrayAdapter = new ArrayAdapter<Chapter>(ChapterActivity.this,android.R.layout.simple_list_item_1, lstChapters);
        mList = (ListView) findViewById(R.id.lstChapter);
        mList.setAdapter(chapterArrayAdapter);
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Chapter chapter = lstChapters.get(position);
                Intent intent = new Intent(ChapterActivity.this,ChapterDetailActivity.class);
                intent.putExtra("chapter", chapter);
                startActivity(intent);
            }
        });

    }
}

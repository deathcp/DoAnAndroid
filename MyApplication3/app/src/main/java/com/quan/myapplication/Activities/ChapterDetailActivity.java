package com.quan.myapplication.Activities;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.quan.myapplication.Entities.Chapter;
import com.quan.myapplication.Managers.BookManager;
import com.quan.myapplication.R;

import java.io.IOException;

public class ChapterDetailActivity extends AppCompatActivity {
    BookManager bookManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_detail);
        try {
            bookManager = new BookManager(ChapterDetailActivity.this);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Chapter chapter = (Chapter) getIntent().getSerializableExtra("chapter");

        setTitle(chapter.getChapterName());

        chapter = bookManager.getChapter(chapter.getChapterID());

        TextView textView = (TextView) findViewById(R.id.detailChapter);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textView.setText(Html.fromHtml(chapter.getChapterContent(), Html.FROM_HTML_MODE_COMPACT));
        } else {
            textView.setText(Html.fromHtml(chapter.getChapterContent()));
        }
    }
}

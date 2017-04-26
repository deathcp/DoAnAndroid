package com.quan.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.quan.myapplication.Entities.Chapter;

public class ChapterDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_detail);

        Chapter chapter = (Chapter) getIntent().getSerializableExtra("chapter");

        setTitle(chapter.getChapterName());

        String chapterContent = chapter.getChapterContent().replaceAll("<br/>","\n").replaceAll("</td>","");
        TextView textView = (TextView) findViewById(R.id.detailChapter);
        textView.setText(chapterContent);
    }
}

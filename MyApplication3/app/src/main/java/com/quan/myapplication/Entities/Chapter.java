package com.quan.myapplication.Entities;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator PC on 25-Apr-17.
 */

public class Chapter implements Serializable {
    private Integer chapterID;
    private String chapterName;
    private String source;
    private String chapterContent;
    private Integer bookID;
    private Date createDate;

    public Chapter() {
    }

    public Chapter(Integer chapterID, String chapterName, String source, String chapterContent, Integer bookID, Date createDate) {
        this.chapterID = chapterID;
        this.chapterName = chapterName;
        this.source = source;
        this.chapterContent = chapterContent;
        this.bookID = bookID;
        this.createDate = createDate;
    }

    public Integer getChapterID() {
        return chapterID;
    }

    public void setChapterID(Integer chapterID) {
        this.chapterID = chapterID;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getChapterContent() {
        return chapterContent;
    }

    public void setChapterContent(String chapterContent) {
        this.chapterContent = chapterContent;
    }

    public Integer getBookID() {
        return bookID;
    }

    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return getChapterName();
    }
}

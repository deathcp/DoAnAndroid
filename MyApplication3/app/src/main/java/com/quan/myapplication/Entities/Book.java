package com.quan.myapplication.Entities;

import java.io.Serializable;

/**
 * Created by Administrator PC on 25-Apr-17.
 */

public class Book implements Serializable{
    private Integer bookID;
    private String bookName;
    private Integer authorID;
    private String imagePath;
    private String bookDescription;

    public Book() {
    }

    public Book(String bookName, Integer bookID, Integer authorID, String imagePath, String bookDescription) {
        this.bookName = bookName;
        this.bookID = bookID;
        this.authorID = authorID;
        this.imagePath = imagePath;
        this.bookDescription = bookDescription;
    }

    public Integer getBookID() {
        return bookID;
    }

    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getAuthorID() {
        return authorID;
    }

    public void setAuthorID(Integer authorID) {
        this.authorID = authorID;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }
}

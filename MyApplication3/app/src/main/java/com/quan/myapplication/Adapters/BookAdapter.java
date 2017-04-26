package com.quan.myapplication.Adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.quan.myapplication.Entities.Book;
import com.quan.myapplication.R;

import java.util.ArrayList;

/**
 * Created by Administrator PC on 25-Apr-17.
 */

public class BookAdapter extends ArrayAdapter {
    ArrayList<Book> mLstBook = new ArrayList<Book>();
    Context mContext;
    int mLayoutResource;

    public BookAdapter(Context context, int layoutResource, ArrayList<Book> books) {
        super(context, layoutResource, books);
        this.mContext = context;
        mLstBook = books;
        mLayoutResource = layoutResource;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(mLayoutResource, null);
        Book book = mLstBook.get(position);
        TextView bookName = (TextView) convertView.findViewById(R.id.bookName);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);
        int drawID = mContext.getResources().getIdentifier(book.getImagePath(),"drawable",mContext.getPackageName());

        imageView.setBackgroundResource(drawID);
        bookName.setText(book.getBookName());
        return convertView;
    }

}

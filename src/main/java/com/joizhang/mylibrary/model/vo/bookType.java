package com.joizhang.mylibrary.model.vo;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/5/9.
 */
public class BookType implements Serializable {
    private String bookType;

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    @Override
    public String toString() {
        return "bookType{" +
                "bookType='" + bookType + '\'' +
                '}';
    }
}

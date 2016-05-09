package com.joizhang.mylibrary.model.vo;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/5/9.
 */
public class BookType implements Serializable {
    private String bookTypeId;
    private String bookType;

    public String getBookTypeId() {
        return bookTypeId;
    }

    public void setBookTypeId(String bookTypeId) {
        this.bookTypeId = bookTypeId;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    @Override
    public String toString() {
        return "BookType{" +
                "bookTypeId='" + bookTypeId + '\'' +
                ", bookType='" + bookType + '\'' +
                '}';
    }
}

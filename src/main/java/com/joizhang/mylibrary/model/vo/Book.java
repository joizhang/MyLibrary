package com.joizhang.mylibrary.model.vo;

import java.sql.Timestamp;

/**
 * Created by Administrator on 2016/4/22.
 */
public class Book {
    private String bookId;
    private String bookName;
    private String bookPhoto;
    private Timestamp createTime;
    private String description;
    private Integer lend;
    private String borrowId;
    private String sellAddress;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookPhoto() {
        return bookPhoto;
    }

    public void setBookPhoto(String bookPhoto) {
        this.bookPhoto = bookPhoto;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLend() {
        return lend;
    }

    public void setLend(Integer lend) {
        this.lend = lend;
    }

    public String getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(String borrowId) {
        this.borrowId = borrowId;
    }

    public String getSellAddress() {
        return sellAddress;
    }

    public void setSellAddress(String sellAddress) {
        this.sellAddress = sellAddress;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", bookName='" + bookName + '\'' +
                ", bookPhoto='" + bookPhoto + '\'' +
                ", createTime=" + createTime +
                ", description='" + description + '\'' +
                ", lend=" + lend +
                ", borrowId='" + borrowId + '\'' +
                ", sellAddress='" + sellAddress + '\'' +
                '}';
    }
}

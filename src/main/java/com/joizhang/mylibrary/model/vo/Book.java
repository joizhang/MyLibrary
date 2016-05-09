package com.joizhang.mylibrary.model.vo;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2016/4/22.
 */
public class Book implements Serializable{
    private String bookId;
    private String bookNumber;
    private String bookName;
    private String bookPhoto;
    private Timestamp createTime;
    private String description;
    private Integer lend;
    private Timestamp lendTime;
    private String borrowId;
    private String sellAddress;
    private String bookType;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(String bookNumber) {
        this.bookNumber = bookNumber;
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

    public Timestamp getLendTime() {
        return lendTime;
    }

    public void setLendTime(Timestamp lendTime) {
        this.lendTime = lendTime;
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

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", bookNumber='" + bookNumber + '\'' +
                ", bookName='" + bookName + '\'' +
                ", bookPhoto='" + bookPhoto + '\'' +
                ", createTime=" + createTime +
                ", description='" + description + '\'' +
                ", lend=" + lend +
                ", lendTime=" + lendTime +
                ", borrowId='" + borrowId + '\'' +
                ", sellAddress='" + sellAddress + '\'' +
                ", bookType='" + bookType + '\'' +
                '}';
    }
}

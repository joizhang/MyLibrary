package com.joizhang.mylibrary.mode.po;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Book entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "book", catalog = "mylibrary")
public class Book implements java.io.Serializable {

	// Fields

	private String bookId;
	private String bookName;
	private String bookPhoto;
	private Timestamp createTime;
	private String description;
	private Integer lend;
	private String borrowId;

	// Constructors

	/** default constructor */
	public Book() {
	}

	/** minimal constructor */
	public Book(String bookId, String bookName, String bookPhoto,
			Timestamp createTime, Integer lend) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookPhoto = bookPhoto;
		this.createTime = createTime;
		this.lend = lend;
	}

	/** full constructor */
	public Book(String bookId, String bookName, String bookPhoto,
			Timestamp createTime, String description, Integer lend,
			String borrowId) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookPhoto = bookPhoto;
		this.createTime = createTime;
		this.description = description;
		this.lend = lend;
		this.borrowId = borrowId;
	}

	// Property accessors
	@Id
	@Column(name = "book_id", unique = true, nullable = false, length = 32)
	public String getBookId() {
		return this.bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	@Column(name = "book_name", nullable = false, length = 32)
	public String getBookName() {
		return this.bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	@Column(name = "book_photo", nullable = false, length = 32)
	public String getBookPhoto() {
		return this.bookPhoto;
	}

	public void setBookPhoto(String bookPhoto) {
		this.bookPhoto = bookPhoto;
	}

	@Column(name = "create_time", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "description", length = 65535)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "lend", nullable = false)
	public Integer getLend() {
		return this.lend;
	}

	public void setLend(Integer lend) {
		this.lend = lend;
	}

	@Column(name = "borrow_id", length = 32)
	public String getBorrowId() {
		return this.borrowId;
	}

	public void setBorrowId(String borrowId) {
		this.borrowId = borrowId;
	}

}
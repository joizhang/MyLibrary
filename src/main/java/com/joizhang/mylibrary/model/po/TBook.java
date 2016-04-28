package com.joizhang.mylibrary.model.po;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TBook entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_book", catalog = "mylibrary")
public class TBook implements java.io.Serializable {

	// Fields

	private String bookId;
	private String bookNumber;
	private String bookName;
	private String bookPhoto;
	private Timestamp createTime;
	private String description;
	private Integer lend;
	private String borrowId;
	private String sellAddress;

	// Constructors

	/** default constructor */
	public TBook() {
	}

	/** minimal constructor */
	public TBook(String bookId, String bookNumber, String bookName,
			Timestamp createTime, Integer lend) {
		this.bookId = bookId;
		this.bookNumber = bookNumber;
		this.bookName = bookName;
		this.createTime = createTime;
		this.lend = lend;
	}

	/** full constructor */
	public TBook(String bookId, String bookNumber, String bookName,
			String bookPhoto, Timestamp createTime, String description,
			Integer lend, String borrowId, String sellAddress) {
		this.bookId = bookId;
		this.bookNumber = bookNumber;
		this.bookName = bookName;
		this.bookPhoto = bookPhoto;
		this.createTime = createTime;
		this.description = description;
		this.lend = lend;
		this.borrowId = borrowId;
		this.sellAddress = sellAddress;
	}

	// Property accessors
	@Id
	@Column(name = "book_id", unique = true, nullable = false, length = 64)
	public String getBookId() {
		return this.bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	@Column(name = "book_number", nullable = false, length = 32)
	public String getBookNumber() {
		return this.bookNumber;
	}

	public void setBookNumber(String bookNumber) {
		this.bookNumber = bookNumber;
	}

	@Column(name = "book_name", nullable = false, length = 32)
	public String getBookName() {
		return this.bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	@Column(name = "book_photo", length = 32)
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

	@Column(name = "borrow_id", length = 64)
	public String getBorrowId() {
		return this.borrowId;
	}

	public void setBorrowId(String borrowId) {
		this.borrowId = borrowId;
	}

	@Column(name = "sell_address", length = 1024)
	public String getSellAddress() {
		return this.sellAddress;
	}

	public void setSellAddress(String sellAddress) {
		this.sellAddress = sellAddress;
	}

}
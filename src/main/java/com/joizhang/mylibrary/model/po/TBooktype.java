package com.joizhang.mylibrary.model.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TBooktype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_booktype", catalog = "mylibrary")
public class TBooktype implements java.io.Serializable {

	// Fields

	private String bookType;

	// Constructors

	/** default constructor */
	public TBooktype() {
	}

	/** full constructor */
	public TBooktype(String bookType) {
		this.bookType = bookType;
	}

	// Property accessors
	@Id
	@Column(name = "bookType", unique = true, nullable = false, length = 100)
	public String getBookType() {
		return this.bookType;
	}

	public void setBookType(String bookType) {
		this.bookType = bookType;
	}

}
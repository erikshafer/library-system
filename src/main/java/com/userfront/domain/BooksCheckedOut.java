package com.userfront.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//@Entity
public class BooksCheckedOut {

	// TODO: Do we need more instance fields for this?
	//@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Date date;
	
//    @ManyToOne
//    @JoinColumn(name = "book_id")
//	private Long bookId;
	
	// Getters and setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
//	public Long getBookId() {
//		return bookId;
//	}
//	public void setBookId(Long bookId) {
//		this.bookId = bookId;
//	}
}

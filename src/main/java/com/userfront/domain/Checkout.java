package com.userfront.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Checkout {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "checkout_id")
	private Long checkoutId;

	@Column(name = "book_id")
	private Long bookId;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	private Date dateBorrowed;
	private Date dateDue;
	private Date dateReturned;

	private boolean checkedOut;

	public Checkout() {

	}

	public Checkout(Long checkoutId, Long bookId, User user, Date dateBorrowed, Date dateDue, Date dateReturned,
	        boolean checkedOut) {
		this.checkoutId = checkoutId;
		this.bookId = bookId;
		this.user = user;
		this.dateBorrowed = dateBorrowed;
		this.dateDue = dateDue;
		this.dateReturned = dateReturned;
		this.checkedOut = checkedOut;
	}

	// @ManyToOne
	// @JoinColumn(name = "user_id")
	// private User user;
	//
	// @ManyToOne
	// @JoinColumn(name = "book_id")
	// private Book book;

	public Long getCheckoutId() {
		return checkoutId;
	}

	public void setCheckoutId(Long checkoutId) {
		this.checkoutId = checkoutId;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDateBorrowed() {
		return dateBorrowed;
	}

	public void setDateBorrowed(Date dateBorrowed) {
		this.dateBorrowed = dateBorrowed;
	}

	public Date getDateDue() {
		return dateDue;
	}

	public void setDateDue(Date dateDue) {
		this.dateDue = dateDue;
	}

	public Date getDateReturned() {
		return dateReturned;
	}

	public void setDateReturned(Date dateReturned) {
		this.dateReturned = dateReturned;
	}

	public boolean isCheckedOut() {
		return checkedOut;
	}

	public void setCheckedOut(boolean checkedOut) {
		this.checkedOut = checkedOut;
	}

	@Override
	public String toString() {
		return "Checkout [checkoutId=" + checkoutId + ", bookId=" + bookId + ", user=" + user + ", dateBorrowed="
		        + dateBorrowed + ", dateDue=" + dateDue + ", dateReturned=" + dateReturned + "]";
	}

}

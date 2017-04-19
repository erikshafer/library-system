package com.userfront.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "book_id", nullable = false, updatable = false)
	private Long id;
	@Column(name = "isbn", nullable = false, unique = true)
	private Long isbn;
	@Column(name = "book_title", nullable = false, unique = false)
	private String bookTitle;
	@Column(name = "author_id", nullable = false, unique = false)
	private String author;
	@Column(name = "publication_country", nullable = true, unique = false)
	private String publicationCountry;
	@Column(name = "publication_year", nullable = true, unique = false)
	private Integer publicationYear;

	public Book() {

	}

	public Book(Long id, Long isbn, String bookTitle, String author, String publicationCountry,
	        Integer publicationYear) {
		this.id = id;
		this.isbn = isbn;
		this.bookTitle = bookTitle;
		this.author = author;
		this.publicationCountry = publicationCountry;
		this.publicationYear = publicationYear;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIsbn() {
		return isbn;
	}

	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String authorName) {
		this.author = authorName;
	}

	public String getPublicationCountry() {
		return publicationCountry;
	}

	public void setPublicationCountry(String publicationCountry) {
		this.publicationCountry = publicationCountry;
	}

	public Integer getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(Integer publicationYear) {
		this.publicationYear = publicationYear;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", isbn=" + isbn + ", bookTitle=" + bookTitle + ", author=" + author
		        + ", publicationCountry=" + publicationCountry + ", publicationYear=" + publicationYear + "]";
	}

}

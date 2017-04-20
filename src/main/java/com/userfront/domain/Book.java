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
	@Column(name = "author_id")
	private Long author;
	@Column(name = "publication_country", nullable = true, unique = false)
	private String publicationCountry;
	@Column(name = "publication_year", nullable = true, unique = false)
	private Long publicationYear;
	@Column(name = "genre_id")
	private Long genre;
	@Column(name = "book_description")
	private String description;
	// TODO: many-to-many author(s)

	public Book() {
	}

	public Book(Long id, Long isbn, String bookTitle, String publicationCountry, Long publicationYear, Long genre,
			Long author, String description) {
		this.id = id;
		this.isbn = isbn;
		this.bookTitle = bookTitle;
		this.publicationCountry = publicationCountry;
		this.publicationYear = publicationYear;
		this.genre = genre;
		this.author = author;
		this.description = description;
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

	public String getPublicationCountry() {
		return publicationCountry;
	}

	public void setPublicationCountry(String publicationCountry) {
		this.publicationCountry = publicationCountry;
	}

	public Long getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(Long publicationYear) {
		this.publicationYear = publicationYear;
	}

	public Long getGenre() {
		return genre;
	}

	public void setGenre(Long genre) {
		this.genre = genre;
	}

	public Long getAuthor() {
		return author;
	}

	public void setAuthor(Long author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

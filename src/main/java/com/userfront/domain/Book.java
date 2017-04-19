package com.userfront.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

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
	private Integer author;
	@Column(name = "publication_country", nullable = true, unique = false)
	private String publicationCountry;
	@Column(name = "publication_year", nullable = true, unique = false)
	private Integer publicationYear;
	@Column(name = "genre_id")
	private Integer genre;
	@Column(name = "book_description")
	private String description;
	// TODO: many-to-many author(s)

	public Book() {
	}

	public Book(Long id, Long isbn, String bookTitle, String publicationCountry, Integer publicationYear, Integer genre,
	        Integer author, String description) {
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

	public Integer getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(Integer publicationYear) {
		this.publicationYear = publicationYear;
	}

	public Integer getGenre() {
		return genre;
	}

	public void setGenre(Integer genre) {
		this.genre = genre;
	}

	public Integer getAuthor() {
		return author;
	}

	public void setAuthor(Integer author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

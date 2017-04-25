package com.userfront.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "book_id", nullable = false, updatable = false)
	private Long id;
	@Column(name = "isbn", nullable = false, unique = true)
	private Long isbn;
	@Column(name = "book_title", nullable = false)
	private String bookTitle;
	@Column(name = "book_in_stock", nullable = false)
	private boolean inStock;
	@Column(name = "book_last_modified", nullable = false)
	private Date lastModified;

	@ManyToOne
	@JoinColumn(name = "author_id")
	private Author author;
	
	@ManyToOne
	@JoinColumn(name = "country_id")
	private Country country;
	
	@Column(name = "publication_year")
	private Long year;

	@ManyToOne
	@JoinColumn(name = "genre_id")
	private Genre genre;
	// @Column(name = "genre_id")
	// private Long genre;

	@Column(name = "book_description")
	private String description;
	// TODO: many-to-many author(s)

	public Book() {
	}

	public Book(Long id, Long isbn, String bookTitle, Country country, Long year, Genre genre,
	        Author author, String description, boolean inStock, Date lastModified) {
		this.id = id;
		this.isbn = isbn;
		this.bookTitle = bookTitle;
		this.country = country;
		this.year = year;
		this.genre = genre;
		this.author = author;
		this.description = description;
		this.inStock = inStock;
		this.lastModified = lastModified;
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

	public Country getPublicationCountry() {
		return country;
	}

	public void setPublicationCountry(Country publicationCountry) {
		this.country = publicationCountry;
	}

	public Long getPublicationYear() {
		return year;
	}

	public void setPublicationYear(Long publicationYear) {
		this.year = publicationYear;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isInStock() {
		return inStock;
	}

	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", isbn=" + isbn + ", bookTitle=" + bookTitle + ", inStock=" + inStock
		        + ", lastModified=" + lastModified + ", author=" + author + ", publicationCountry=" + country
		        + ", publicationYear=" + year + ", genre=" + genre + ", description=" + description + "]";
	}

}

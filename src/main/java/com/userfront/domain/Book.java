package com.userfront.domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.userfront.domain.security.Authority;
import com.userfront.domain.security.UserRole;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, updatable = false)
	private Long id;
	@Column(name = "isbn", nullable = false, unique = true)
	private Long isbn;
	@Column(name = "book_title", nullable = false, unique = false)
	private String bookTitle;
	@Column(name = "author_name", nullable = false, unique = false)
	private String author;
	@Column(name = "publication_country", nullable = true, unique = false)
	private String publicationCountry;
	@Column(name = "publication_year", nullable = true, unique = false)
	private Integer publicationYear;

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

}

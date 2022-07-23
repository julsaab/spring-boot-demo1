package com.juliensaab.sf.demo1.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created on 7/23/2022
 *
 * @author Julien Saab
 */
@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToMany
	@JoinTable(name = "author_book",
			joinColumns = @JoinColumn(name = "book_id"),//ID to be mapped to the current class
			inverseJoinColumns = @JoinColumn(name = "author_id") //ID to be mapped to the property's class
	)
	private Set<Author> authors = new HashSet<>();
	@ManyToOne(optional = false)
	private Publisher publisher;
	private String title;
	private String isbn;

	public Book() {

	}

	public Long getId() {

		return id;
	}

	public void setId(Long id) {

		this.id = id;
	}

	public Set<Author> getAuthors() {

		return authors;
	}

	public void setAuthors(Set<Author> authors) {

		this.authors = authors;
	}

	public Publisher getPublisher() {

		return publisher;
	}

	public void setPublisher(Publisher publisher) {

		this.publisher = publisher;
	}

	public String getTitle() {

		return title;
	}

	public void setTitle(String title) {

		this.title = title;
	}

	public String getIsbn() {

		return isbn;
	}

	public void setIsbn(String isbn) {

		this.isbn = isbn;
	}

	@Override
	public boolean equals(Object o) {

		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Book book = (Book) o;

		return id != null ? id.equals(book.id) : book.id == null;
	}

	@Override
	public int hashCode() {

		return id != null ? id.hashCode() : 0;
	}

	@Override
	public String toString() {

		return "Book{" +
				"id=" + id +
				", title='" + title + '\'' +
				", isbn='" + isbn + '\'' +
				'}';
	}
}

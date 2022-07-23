package com.juliensaab.sf.demo1.bootstrap;

import com.juliensaab.sf.demo1.model.Author;
import com.juliensaab.sf.demo1.model.Book;
import com.juliensaab.sf.demo1.model.Publisher;
import com.juliensaab.sf.demo1.repositories.AuthorRepository;
import com.juliensaab.sf.demo1.repositories.BookRepository;
import com.juliensaab.sf.demo1.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created on 7/23/2022
 *
 * @author Julien Saab
 */
@Component
public class BootStrapData implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;

	public BootStrapData(AuthorRepository authorRepository,
	                     BookRepository bookRepository,
	                     PublisherRepository publisherRepository) {

		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		{
			Publisher publisher = new Publisher();
			publisher.setName("The good publisher");
			publisher.setCity("Beirut");
			publisher.setState("Beirut");
			publisher.setZip("0000");
			publisher.setAddressLine1("Somewhere in beirut");

			publisherRepository.save(publisher);

			Author julien = new Author();
			julien.setFirstName("Julien");
			julien.setLastName("Saab");

			authorRepository.save(julien);

			Book book1 = new Book();
			book1.setPublisher(publisher);
			book1.setIsbn("978123456789712345");
			book1.setTitle("Spring Tutorial");

			bookRepository.save(book1);

			publisher.getBooks().add(book1);
			julien.getBooks().add(book1);
			book1.getAuthors().add(julien);

			publisherRepository.save(publisher);
			authorRepository.save(julien);
			bookRepository.save(book1);
		}

		System.out.println("Number of books: " + bookRepository.count());
		System.out.println("Number of publishers: " + publisherRepository.count());
	}
}

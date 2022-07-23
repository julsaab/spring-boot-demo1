package com.juliensaab.sf.demo1.repositories;

import com.juliensaab.sf.demo1.model.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * Created on 7/23/2022
 *
 * @author Julien Saab
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}

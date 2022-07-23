package com.juliensaab.sf.demo1.repositories;

import com.juliensaab.sf.demo1.model.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 * Created on 7/23/2022
 *
 * @author Julien Saab
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}

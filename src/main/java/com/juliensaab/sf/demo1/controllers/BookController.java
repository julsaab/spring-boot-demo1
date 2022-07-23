package com.juliensaab.sf.demo1.controllers;

import com.juliensaab.sf.demo1.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created on 7/23/2022
 *
 * @author Julien Saab
 */
@Controller
public class BookController {

	private final BookRepository bookRepository;

	public BookController(BookRepository bookRepository) {

		this.bookRepository = bookRepository;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/books")
	public String getBooks(Model model) {

		//The model is going to be returned to the view
		model.addAttribute("books", bookRepository.findAll());

		return "books/list"; //This is the view name
	}
}

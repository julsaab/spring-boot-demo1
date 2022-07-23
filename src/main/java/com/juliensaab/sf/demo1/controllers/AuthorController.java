package com.juliensaab.sf.demo1.controllers;

import com.juliensaab.sf.demo1.repositories.AuthorRepository;
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
public class AuthorController {

	private AuthorRepository authorRepository;

	public AuthorController(AuthorRepository authorRepository) {

		this.authorRepository = authorRepository;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/authors")
	public String getAuthors(Model model) {

		model.addAttribute("authors", authorRepository.findAll());

		return "authors/list";
	}
}

package com.sample.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.sample.model.Book;
import com.sample.repo.Repository;

/**
 * 
 * @author andrucris
 *
 *         I have a class which contains a List of an Object. When I make a
 *         REST, I want to transform the list in that class to another Object
 *         and send it back to the caller...
 */
@RestController
public class RestWithLIst {

	@Autowired
	private Repository repo;

	/**
	 * 
	 * method return a list object to the caller
	 * 
	 * @return response containting the result of the operation
	 */
	@RequestMapping(path = "/books")
	public String books() {

		loadListWithBooks();
		return parseToJson();

	}

	public String parseToJson() {
		Gson gson = new Gson();
		return gson.toJson(repo.getBookList());
	}

	private void loadListWithBooks() {
		List<Book> bookList = repo.getBookList();
		Book book1 = new Book();
		book1.setTitle("Book1");
		book1.setPrice(20.0);
		bookList.add(book1);
		Book book2 = new Book();
		book2.setTitle("Book1");
		book2.setPrice(30.0);
		bookList.add(book2);
	}

}
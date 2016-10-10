package com.sample.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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
	 * @return response containing the result of the operation
	 */
	@RequestMapping(path = "/books/expensive")
	public String expensiveBooks() {

		return parseToJson(evaluate(repo.getBookList(), (book) -> book.getPrice() > 100));

	}

	/**
	 * 
	 * method return a list object to the caller
	 * 
	 * @return response containing the result of the operation
	 */
	@RequestMapping(path = "/books/cheap")
	public String cheapBooks() {

		return parseToJson(evaluate(repo.getBookList(), (book) -> book.getPrice() < 100));

	}

	public String parseToJson(List<Book> list) {
		Gson gson = new Gson();
		return gson.toJson(list);
	}

	public List<Book> evaluate(List<Book> list, Predicate<Book> predicate) {
		List<Book> bookList = new ArrayList<>();
		for (Book book : list) {
			if (predicate.test(book)) {
				bookList.add(book);
			}
		}
		return bookList;
	}

}
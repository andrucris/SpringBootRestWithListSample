package com.sample.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import com.sample.model.Book;

@Component
public class Repository {

	private List<Book> bookList = null;

	public Repository() {
		bookList = new ArrayList<>();
		loadListWithBooks();// initialize collection with books
	}

	private void loadListWithBooks() {
		Book book1 = new Book();
		book1.setTitle("Book1");
		book1.setPrice(20.0);
		bookList.add(book1);

		Book book2 = new Book();
		book2.setTitle("Book1");
		book2.setPrice(300.0);
		bookList.add(book2);

		Book book3 = new Book();
		book3.setTitle("Book3");
		book3.setPrice(40.0);
		bookList.add(book2);

		setBookList(Stream.of(book1, book2, book3).collect(Collectors.toList()));

	}

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

}

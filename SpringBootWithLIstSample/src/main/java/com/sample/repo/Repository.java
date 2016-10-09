package com.sample.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sample.model.Book;

@Component
public class Repository {

	private List<Book> bookList = new ArrayList<>();

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}
}

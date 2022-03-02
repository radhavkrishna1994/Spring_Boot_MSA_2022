package com.training.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.data.BookData;
import com.training.model.Book;

@Service
public class BookService {

	@Autowired
	private BookData bookData;
	
	public List<Book> getAllBooks()
	{
		return bookData.getAllBooks();
	}
	
	public Book getBook(long isbn)
	{
		return bookData.getBook(isbn);
	}
	
	public boolean addBook(Book book)
	{
		return bookData.addBook(book);
	}
}

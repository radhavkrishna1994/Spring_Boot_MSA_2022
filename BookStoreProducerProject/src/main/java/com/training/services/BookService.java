package com.training.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.model.Book;
import com.training.repo.BookRepo;

@Service
public class BookService {

	@Autowired
	private BookRepo bookRepo;
	
	public List<Book> getAllBooks()
	{
		return bookRepo.findAll();
	}
	
	public Book getBook(long isbn)
	{
		Optional<Book> opBook = bookRepo.findById(isbn);
		if(opBook.isPresent())
			return opBook.get();
		
		return null; 
	}
	
	public Book addBook(Book book)
	{
		return bookRepo.save(book);
	}
	
	public Book deleteBook(long isbn)
	{
		Optional<Book> opBook = bookRepo.findById(isbn);
		if(opBook.isPresent())
		{
			Book bookDeleted = opBook.get();
			bookRepo.delete(bookDeleted);
			return bookDeleted;
		}
		return null;
	}
}

package com.training.services;

import java.util.ArrayList;
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
		//return new ArrayList<Book>();
		List<Book> books = bookRepo.findAll();
		//System.out.println(books);
		return books;
	}
	
	
	public Book getBook(long isbn)
	{
		Optional<Book> opBook = bookRepo.findById(isbn);
		Book book=null;
		if(opBook.isPresent())
		{
			book=opBook.get();
			System.out.println(book);return book;
		}
			
		
		return null; 
	}
	
	public Book getBookIsbn(long isbn)
	{
		return bookRepo.findByIsbn(isbn);
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

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
		
	// get all books
	public List<Book> getBooks()
	{
		return bookRepo.findAll();
	}
	
	public Book getBook(Long isbn)
	{
		Optional<Book> opBook = bookRepo.findById(isbn);
		if(opBook.isPresent())
		return opBook.get();
		
		return null;
	}
	
	public Book deleteBook(Long isbn)
	{
		Optional<Book> opBook = bookRepo.findById(isbn);
		if(opBook.isPresent())
		{
			Book bookFound=opBook.get();
			bookRepo.delete(bookFound);
			return bookFound;
		}
	return null;
	}
	
	public Book addBook(Book book)
	{
		try {
		return bookRepo.save(book);
		}
		catch(Exception e)
		{
			return null;
		}
		
	}
	public Book updateBook(Long isbn,Long newStock)
	{
		Optional<Book> opBook = bookRepo.findById(isbn);
		if(opBook.isPresent())
		{
			Book bookFound=opBook.get();
			bookFound.setStock(bookFound.getStock()+newStock);
			bookRepo.save(bookFound);
			return bookFound;
		}
	return null;
	}
	
}

package com.training.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.bean.Book;
import com.training.interfaces.BookServiceI;
import com.training.repo.BookRepo;

@Service
public class BookService implements BookServiceI {

	@Autowired
	private BookRepo bookRepo;
	
	@Override
	public List<Book> findAll() {
			return bookRepo.findAll();
	}

	@Override
	public Book addBook(Book book) {
		return bookRepo.save(book);
	}

	@Override
	public boolean deleteById(String isbn) {
		Book book = bookRepo.findById(isbn).get();
		if(book!=null)	{
			bookRepo.delete(book);return true;}
		
		return false;
	}

	@Override
	public Book updateStock(String isbn, long newStock) {
		Book book = bookRepo.findById(isbn).get();
		book.setStock(book.getStock()+newStock);
		bookRepo.save(book);
		return book;
	}

	@Override
	public Book getBook(String isbn) {
		
		return bookRepo.findById(isbn).get();
	}

	@Override
	public List<Book> getAllBooksPattern(String pattern) {
		
		return bookRepo.findByTitleLike(pattern);
	}
	
	

}

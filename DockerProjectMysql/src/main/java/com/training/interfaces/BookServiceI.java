package com.training.interfaces;

import java.util.List;

import com.training.bean.Book;

public interface BookServiceI
{
	List<Book> findAll();
	Book addBook(Book book);
	boolean deleteById(String isbn);
	Book updateStock(String isbn,long newStock);
	Book getBook(String isbn);
	List<Book> getAllBooksPattern(String pattern);
}
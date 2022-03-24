package com.training.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.model.Book;
import com.training.services.BookService;

@RequestMapping("/bookstore")
@RestController
public class BookController {

	@Autowired	
	private BookService bookService;

	@GetMapping(value = "/books")  // http://localhost:8081/bookstore/books
	public List<Book> getBooks()
	{
		return bookService.getBooks();
	}
	
	// http://localhost:8081/bookstore/book/isbn/1234
	@GetMapping("/book/isbn/{isbn}")  
	public Book getBook(@PathVariable("isbn") Long isbn)
	{
		return bookService.getBook(isbn);
	}
	
	@DeleteMapping("/book/isbn/{isbn}")  
	public Book deleteBook(@PathVariable("isbn") Long isbn)
	{
		return bookService.deleteBook(isbn);
	}
	
	@PostMapping
	public Book addBook(@RequestBody  Book book)
	{
		return bookService.addBook(book);
	}
	
	@PutMapping("/book/isbn/{isbn}/stock/{stock}")  
	public Book updateBook(@PathVariable("isbn") Long isbn,
			@PathVariable("stock") Long stock)
	{
		return bookService.updateBook(isbn, stock);
	}
	
	
}

package com.training.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.training.model.Book;
import com.training.services.BookService;



@RequestMapping("/bookstore")
@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;

	@GetMapping("/hello")  // localhost:8082/bookstore/hello
	public String sayHello()
	{
		return "hello world";
	}
	
	@GetMapping("/books")          // localhost:8082/bookstore/books
	public List<Book> getBooks()
	{
		return bookService.getAllBooks();
	}
	
	
	@GetMapping("/book/isbn/{isbn}")         // localhost:8082/bookstore/book/isbn/1234
	public Book getBook(@PathVariable("isbn") long isbn)
	{
		return bookService.getBook(isbn);
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/addbook")
	public Book addBook(@RequestBody Book book)
	{
		return bookService.addBook(book);
	}
	
	
	
}

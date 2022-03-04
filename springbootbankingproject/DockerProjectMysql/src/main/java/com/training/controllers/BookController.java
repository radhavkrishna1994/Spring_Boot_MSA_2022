package com.training.controllers;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.bean.Book;
import com.training.interfaces.BookServiceI;
import com.training.services.BookService;

@RestController
@RequestMapping("/bookstore/api")
public class BookController {

	@Autowired
	private BookServiceI bookService;
	
	@GetMapping("/getallbooks")
	public List<Book> getBooks()
	{
		return bookService.findAll();
	}
	
	@PostMapping("/addbook")
	public Book addBook(@RequestBody Book book)
	{
		return bookService.addBook(book);
	}
	
	//localhost:8082/bookstore/api/delbook/isbn/2345
	@DeleteMapping("/delbook/isbn/{isbn}") 
	public boolean deleteBook(@PathVariable("isbn") String isbn)
	{
		return bookService.deleteById(isbn);
	}
	
	//localhost:8082/bookstore/api//upstock/isbn/2345/stock/50
	@GetMapping("/upstock/isbn/{isbn}/stock/{stock}") 
	public Book updateStock(@PathVariable("isbn") String isbn,@PathVariable("stock") long stock)
	{
		return bookService.updateStock(isbn,stock);
	}
	
	@GetMapping("/getbook/isbn/{isbn}")
	public Book getBook(@PathVariable("isbn") String isbn)
	{
		return bookService.getBook(isbn);
	}
	
	@GetMapping("/getBooks/pattern/{pattern}")
	public List<Book> getBooksPattern(@PathVariable("pattern") String pattern)
	{
		return bookService.getAllBooksPattern(pattern);
	}
	
	@GetMapping("/sayHello")
	public String sayHello()
	{
		return "Hello Docker";
	}
	
}





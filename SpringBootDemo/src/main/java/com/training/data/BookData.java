package com.training.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.training.model.Book;

@Repository
public class BookData {
	
		private List<Book> bookList;
		
		public BookData()
		{
			bookList = new ArrayList<>();
			bookList.add(new Book(1234, "C", 125.20, 100));
			bookList.add(new Book(346, "CPlus", 250.20, 100));
			bookList.add(new Book(1234, "Python", 125.20, 100));
		}
		
		public List<Book> getAllBooks()
		{
			return bookList;
		}
		
		public Book getBook(long isbn)
		{
			for(Book book:bookList)
			{
				if(book.getIsbn()==isbn)
					return book;
			}
			return null;
		}
		
		public boolean addBook(Book book)
		{
			return bookList.add(book);
		}

}

package com.training;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.assertj.core.util.Arrays;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.model.Book;
import com.training.repo.BookRepo;
import com.training.services.BookService;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookStoreProducerProjectApplicationTests {

	@Test
	void contextLoads() {
	}

	/*
	 * @Autowired private BookService bookService;
	 * 
	 * @MockBean private BookRepo bookRepo;
	 * 
	 * 
	 * @Test public void getBooksTest() { List<Book> list1 = IntStream.range(1, 5)
	 * .mapToObj(i->new Book(1, "book"+i, 120, 100)) .collect(Collectors.toList());
	 * 
	 * 
	 * List<Book> list = Stream.of(new Book(1, "C", 150.25, 100), new Book(2,
	 * "CPlus", 174.50, 100)).collect(Collectors.toList());
	 * 
	 * when(bookRepo.findAll()).thenReturn(list);
	 * 
	 * assertEquals(2, bookService.getAllBooks().size()); }
	 * 
	 * @Test public void getBookIsbnTest(){ Book book1 = new Book(1, "C", 150.20,
	 * 100); when(bookRepo.findByIsbn(1l)) .thenReturn(book1);
	 * 
	 * assertEquals(book1,bookService.getBookIsbn(1));
	 * 
	 * }
	 * 
	 * @Test public void addBookTest() { Book book1 = new Book(1, "C", 150.20, 100);
	 * when(bookRepo.save(book1)).thenReturn(book1);
	 * 
	 * assertSame(book1,bookService.addBook(book1)); }
	 */
	
	@Autowired
	private WebApplicationContext context;

	
	
	private MockMvc mockMvc;
	
	
	@Before
	public void setUp() {
		System.out.println("In Setup..............");
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void addBookTestMvc() throws Exception
	{
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		Book b1=new Book(12345, "abcd", 150.25, 100);
		ObjectMapper om=new ObjectMapper();
		String jsonInput = om.writeValueAsString(b1);

		MvcResult result = mockMvc.
				perform(post("/bookstore/addbook")
						.content(jsonInput)
						.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();

		String resultString = result.getResponse().getContentAsString();
		Book bookResponse = om.readValue(resultString, Book.class);
		System.out.println(bookResponse);
		assertEquals(b1,bookResponse);

	}
	
	@Test
	public void getBooksTest() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		ObjectMapper om=new ObjectMapper();
		MvcResult result = mockMvc
				.perform(get("/bookstore/books").
						content(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		String resultContent = result.getResponse().getContentAsString();
		List<Book> response = om.readValue(resultContent,List.class);
		Assert.assertNotNull(response);

	}
	
	@Test
	public void getBookIsbnTest() throws Exception {
		Book b1=new Book(1234, "C", 150.25, 100);
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		ObjectMapper om=new ObjectMapper();
		MvcResult result = mockMvc
				.perform(get("/bookstore/getbook/isbn/{isbn}",1234l)
				.content(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		String resultContent = result.getResponse().getContentAsString();
		System.out.println("Result Content:"+resultContent);
		Book response = om.readValue(resultContent,Book.class);
		Assert.assertEquals(b1,response);

	}




}




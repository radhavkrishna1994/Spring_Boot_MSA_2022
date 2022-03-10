package com.training;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.model.Book;
import com.training.repo.BookRepo;
import com.training.services.BookService;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringBootTestingProjectApplicationTests {

	@Test
	void contextLoads() {
	}

	/*
	 * @Autowired private BookService bookService;
	 * 
	 * @Before public void init() {
	 * 
	 * }
	 * 
	 * @Test public void helloTest() { String actualResult =
	 * bookService.sayHelloService();
	 * 
	 * assertEquals("hello world", actualResult); }
	 * 
	 * @Test public void arrayTest() { int[] actualResult = bookService.getArray();
	 * assertTrue(actualResult.length==4); }
	 * 
	 * @MockBean private BookRepo bookRepo;
	 * 
	 * @Test
	 * 
	 * @Ignore public void getAllBooksTest() { List<Book> list = Stream.of(new
	 * Book(1234, "C", 150.25, 100l) ,new Book(6789, "CPlus", 250.25,
	 * 100l)).collect(Collectors.toList());
	 * 
	 * when(bookRepo.findAll()).thenReturn(list);
	 * 
	 * assertEquals(2,bookService.getAllBooks().size()); }
	 * 
	 * @Test
	 * 
	 * @Ignore public void getBookIsbnTest() {
	 * 
	 * Book book1 = new Book(1234, "C", 150.25, 100l);
	 * when(bookRepo.findByIsbn(1234)).thenReturn(book1);
	 * 
	 * assertEquals(book1,bookService.getBookIsbn(1234));
	 * 
	 * }
	 * 
	 * @Test public void addBookTest() { Book book1 = new Book(1234, "C", 150.25,
	 * 100l);
	 * 
	 * when(bookRepo.save(book1)).thenReturn(book1);
	 * 
	 * assertEquals(book1,bookService.addBook(book1)); }
	 */
	
	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp()
	{
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void addBookMvcTest() throws Exception
	{
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		Book b1= new Book(5678, "Python", 120.20, 100);
		ObjectMapper om=new ObjectMapper();
		String bookJsonContentInput = om.writeValueAsString(b1); 
		
		MvcResult result = mockMvc
		.perform(post("/bookstore/addbook")
		.content(bookJsonContentInput)	
		.contentType(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(status().isCreated()).andReturn();
		
		String resultString = result.getResponse().getContentAsString();
		Book bookResponse = om.readValue(resultString,Book.class);	
	
		assertEquals(b1,bookResponse);
	}
	
	@Test
	public void getAllBooksTest() throws Exception
	{
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		MvcResult result = mockMvc.perform(get("/bookstore/books")
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		
		String resultString = result.getResponse().getContentAsString();
		ObjectMapper om=new ObjectMapper();
		List<Book> responseList = om.readValue(resultString, List.class);
		assertNotNull(responseList);
				
	}
	
	
	
}

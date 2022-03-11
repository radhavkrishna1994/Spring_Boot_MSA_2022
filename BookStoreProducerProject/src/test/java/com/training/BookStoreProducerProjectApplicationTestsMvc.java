package com.training;


import static org.junit.Assert.assertSame;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.model.Book;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookStoreProducerProjectApplicationTestsMvc {
	@Test
	void contextLoads() {
	}
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext context;;
	
	@Before
	public void setUp()
	{
		System.out.println("here");
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		
	}
	
	@Test
	public void addBookTest() throws Exception
	{
		Book b1=new Book(1234, "C", 150.25, 100);
		ObjectMapper om=new ObjectMapper();
		String jsonInput = om.writeValueAsString(b1);
		
		MvcResult result = mockMvc.
		perform(post("/bookstore/addbook")
		.content(jsonInput)
		.contentType(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(status().isAccepted()).andReturn();
		
		String resultString = result.getResponse().getContentAsString();
		Book bookResponse = om.readValue(resultString, Book.class);
		assertSame(b1,bookResponse);
		
	}
	
	
}

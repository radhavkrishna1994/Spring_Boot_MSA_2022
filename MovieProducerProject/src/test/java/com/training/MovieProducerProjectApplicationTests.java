package com.training;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.training.repo.MovieRepo;
import com.training.services.MovieService;

@SpringBootTest
class MovieProducerProjectApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private MovieService movieService;
	
	@MockBean
	private MovieRepo movieRepo;
	
	

}

package com.training;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.training.bean.Movie;
import com.training.repo.MovieRepo;


@SpringBootApplication
public class MovieProducerProjectApplication {

	@Autowired
	private MovieRepo repo;
	
	public static void main(String[] args) {
		SpringApplication.run(MovieProducerProjectApplication.class, args);
	}
	/*
	 * @PostConstruct public void init() { Movie m1=new Movie(); m1.setTitle("abc");
	 * m1.setGenre("thriller"); repo.save(m1); }
	 */
	
	
	
}

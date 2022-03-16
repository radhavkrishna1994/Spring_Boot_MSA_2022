package com.training.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.bean.Movie;
import com.training.services.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {
	@Autowired
	private MovieService movieService;
	
	@GetMapping("/test")
	public String test()
	{
		return "test";
	}
	
	// mapping to get movie  based on Id
	@GetMapping("/movie/id/{movieid}")
	public Movie getMovie(@PathVariable("movieid") long movieId)
	{
		return movieService.getMovie(movieId);
	}
	
	
	// mapping to get all movies based on genre
	@GetMapping("/movie/genre/{genre}")
	public List<Movie> getMovieGenre(@PathVariable("genre") String genre)
	{
		return movieService.getMoviesGenre(genre);
	}
	
	
	// mapping to get all movies based on title pattern
	@GetMapping("/movie/title/{pattern}")
	public List<Movie> getMovieTitle(@PathVariable("pattern") String pattern)
	{
		return movieService.getMoviesGenre(pattern);
	}
	
	@GetMapping
	public List<Movie> getMovies()
	{
		return movieService.getMovies();
	}
}

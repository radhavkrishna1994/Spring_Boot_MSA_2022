package com.training.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.bean.Movie;
import com.training.repo.MovieRepo;

@Service
public class MovieService {
	
	private Logger log = LoggerFactory.getLogger(MovieService.class);
	@Autowired
	private MovieRepo movieRepo;
	
	public Movie getMovie(long movieId)
	{
		Optional<Movie> movieOp = movieRepo.findById(movieId);
		if(movieOp.isPresent()) {
		Movie movie =  movieOp.get();
		log.info(movie.getTitle()+" Found with id"+ movieId);
			return movie;
		
		}
		else {
			log.info("Movie not found for id"+movieId);
		return null;
		}
	}
	
	public List<Movie> getMoviesGenre(String genre)
	{
		return movieRepo.findAll();
	}
	
	public List<Movie> getMoviesTitlePattern(String pattern)
	{
		return movieRepo.findByTitleLike(pattern);
	}

	public List<Movie> getMovies()
	{
		return movieRepo.findAll();
	}
}

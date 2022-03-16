package com.training.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.bean.Movie;

@Repository
public interface MovieRepo extends JpaRepository<Movie,Long>{

	/* get Movie List based on title pattern */
	List<Movie> findByTitleLike(String title);
	/* get all Movies based on a Genre */
	List<Movie> findByGenre(String genre);
	
}

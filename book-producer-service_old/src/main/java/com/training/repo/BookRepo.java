package com.training.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.training.model.Book;

@Repository
public interface BookRepo  extends JpaRepository<Book, Long>{

	// get books based on title 
	public List<Book> findByTitle(String title);
	
	public List<Book> findByTitleAndStock(String title,Long stock);
	
	@Query("select b from Book b where b.title=:title")
	public List<Book> getBookOnTitle(@Param("title") String title);
	
}

package com.training.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.training.model.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Long>{

	public Book findByIsbn(long isbn);
	
	// get books based on title
	public List<Book> findByTitle(String title); // python
	
	// get books based on title pattern 
	public List<Book> findByTitleLike(String title);
	
	public List<Book> findByPriceAndStock(double price,long stock);
	
	
	@Query("from Book b where b.title=:title")
	public List<Book> getBooksTitle(@Param("title") String title);
	
	// get Books that are priced less than 200 and stock > 80
	
	@Query("from Book b where b.price < :price and b.stock > :stock")
	public List<Book> findByPriceAndStockC(@Param("price") double price,@Param("stock") long stock);
	
	//update stock of books have stock less than 150 ,by 50 
	
	@Transactional
	@Modifying
	@Query("update Book b set b.stock=b.stock+:newstock where b.stock < :somestock")
	public int updateStockBooks(@Param("newstock") long newstock,@Param("somestock") long someStock);
	
}




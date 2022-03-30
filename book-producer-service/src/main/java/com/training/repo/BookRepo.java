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
public interface BookRepo  extends JpaRepository<Book, Long>{

	// get books based on title 
	public List<Book> findByTitle(String title);
	
	public List<Book> findByTitleAndStock(String title,Long stock);
	
	@Query("select b from Book b where b.title=:title") // Let us C
	public List<Book> getBookOnTitle(@Param("title") String title);
	
	@Query("select b from Book b where b.title like :title") // C
	public List<Book> getBookOnTitleLike(@Param("title") String titlePattern);
	
	// books that are priced less than 150
	
	public List<Book> findByPriceLessThan(Double price);
	
	@Query("select b from Book b where b.price < :price")
	public List<Book> getBookByPriceLt(@Param("price") Double price);
	
	//updating 
	
	@Transactional
	@Modifying
	@Query("update Book b set b.stock=b.stock+:newstock where b.title = :title")
	public int updateStockOnTitle(@Param("title") String title,@Param("newstock") Long newStock);
	
	
}

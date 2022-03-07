package com.training.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.training.bean.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, String> {

	public List<Book> findByTitle(String title);
	public List<Book> findByStock(long stock);
	public Book findByIsbnAndTitle(String isbn,String title);

	//find all books based on title pattern.
	
	public List<Book> findByTitleLike(String pattern);
	
	//find all books whose stock is < n
	
	public List<Book> findByStockLessThan(long stock);
	
	@Query("select b from Book b where b.title like :p")
	public List<Book> abc(@Param("p") String pattern);
	
	@Query("select b from Book b where b.stock < :stock")
	public List<Book> booksLessThanStock(@Param("stock") long stock);
	
	@Transactional
	@Modifying
	@Query("update Book b set b.stock=:newstock where b.stock < :stock")
	public int updateStock(@Param("newstock") long newstock,@Param("stock") long stock);
	
		
	
	
}
	
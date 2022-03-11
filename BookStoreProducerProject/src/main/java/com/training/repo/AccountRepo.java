package com.training.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.training.model.Account;




@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {

	@Query("from Account a where a.customer.custId=:custid")
	public List<Account> findByCustomer(@Param("custid")long custId);
	
	@Query("from Account a where a.doa between :startdate and :enddate")
	public List<Account> getAccounts(@Param("startdate") LocalDate startDate,@Param("enddate")LocalDate endDate);
}

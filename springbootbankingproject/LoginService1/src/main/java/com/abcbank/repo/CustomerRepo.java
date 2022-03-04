package com.abcbank.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abcbank.bean.Customer;



public interface CustomerRepo extends JpaRepository<Customer, Long> {

}

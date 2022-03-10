package com.training.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.model.Customer;





public interface CustomerRepo extends JpaRepository<Customer, Long> {

}

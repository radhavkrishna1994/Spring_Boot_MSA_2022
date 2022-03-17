package com.training.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.training.model.UserTransaction;

public interface UserTransactionRepository extends JpaRepository<UserTransaction,Integer> {
}

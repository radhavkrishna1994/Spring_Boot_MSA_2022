package com.training.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.model.UserBalance;

public interface UserBalanceRepository extends JpaRepository<UserBalance,Integer> {
}

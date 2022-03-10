package com.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}

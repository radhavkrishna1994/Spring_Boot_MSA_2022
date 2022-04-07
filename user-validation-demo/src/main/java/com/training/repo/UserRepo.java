package com.training.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

	public User findByUserId(Long userId);
}

package com.abcbank.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abcbank.bean.MyUser;





@Repository
public interface UserRepo extends JpaRepository<MyUser, String> {

}

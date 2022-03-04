package com.training.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.bean.Notification;

public interface NotificationRepo extends JpaRepository<Notification, Long> {

}

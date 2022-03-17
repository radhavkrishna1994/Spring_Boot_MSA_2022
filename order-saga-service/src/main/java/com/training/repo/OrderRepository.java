package com.training.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.model.PurchaseOrder;

public interface OrderRepository extends JpaRepository<PurchaseOrder,Integer> {
}

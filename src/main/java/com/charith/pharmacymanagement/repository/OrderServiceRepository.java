package com.charith.pharmacymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.charith.pharmacymanagement.entity.Order;

public interface OrderServiceRepository extends JpaRepository<Order, Integer> {

}

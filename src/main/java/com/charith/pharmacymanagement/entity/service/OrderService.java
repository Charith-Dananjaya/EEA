package com.charith.pharmacymanagement.entity.service;

import java.util.List;

import com.charith.pharmacymanagement.entity.Order;


public interface OrderService {
	
	
	List<Order> findAllOrders();
	
	Order getOrderById(int id);
	
	void deleteOrder(int id);
	
	void saveOrder(Order order);

}

package com.charith.pharmacymanagement.entity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.charith.pharmacymanagement.entity.Order;
import com.charith.pharmacymanagement.repository.OrderServiceRepository;

@Service
public class OrderServiceImpl implements OrderService {
	
	
	private OrderServiceRepository orderservicerepository;
	
	@Autowired
	public OrderServiceImpl(OrderServiceRepository orderservicerepository) {
		this.orderservicerepository = orderservicerepository;
	}

	@Override
	public List<Order> findAllOrders() {
		
		return orderservicerepository.findAll();
	}

	@Override
	public Order getOrderById(int id) {
		Order order = null;
		Optional <Order> result = orderservicerepository.findById(id);
		if(result.isPresent()) {
			order = result.get();
		}else {
			throw new RuntimeException("Not Found");
		}
		return order;
	}

	@Override
	public void deleteOrder(int id) {
		
		orderservicerepository.deleteById(id);

	}

	@Override
	public void saveOrder(Order order) {
		orderservicerepository.save(order);

	}

}

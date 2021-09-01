package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.OrderRepository;
import com.example.model.OrderModel;
import com.example.tempmodel.OrderListModel;

@RestController
@CrossOrigin(origins = "*")
public class OrderController {
	
	@Autowired
	public OrderRepository orderRepo;
	
	@GetMapping("/user/{id}/orders")
	public List<OrderModel> getOrdersForUser(@PathVariable String id) {
		return orderRepo.findByUserId(id);
	}
	
	@PostMapping("/user/addorder")
	public boolean addorder(@RequestBody List<OrderModel> orderList) {
		
		orderList.forEach(list -> orderRepo.save(list));	
		return true;
	}
	
	@DeleteMapping("/user/deleteorder/{id}")
	public void deleteOrder(@PathVariable String orderId) {
		orderRepo.deleteById(orderId);
	}
	
	@DeleteMapping("/user/deleteall")
	public void deleteAll() {
		orderRepo.deleteAll();
	}
	
}

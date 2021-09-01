package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.CartModel;

@Repository
public interface CartRepository extends JpaRepository<CartModel, String> {
	
//	List<CartModel> findByAllUserId(String userId);
	List<CartModel> findByUserId(String userId);
	
}

package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.CartRepository;
import com.example.model.CartModel;
import com.example.model.ProductModel;
import com.example.service.ProductService;
import com.example.tempmodel.TmpCartModel;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CartController {
	
	@Autowired
	public CartRepository cartRepo;
	
	@Autowired
	public ProductService productService;
	
	@GetMapping("/user/{id}/cartitems")
	public List<CartModel> getAllCartItemsFromUser(@PathVariable String id) {
		//return the cartItem
		//Enter your code here ...
	}
	
	@PostMapping("/user/addcart")
	public String addtoCart(@RequestBody CartModel cart) {
		return productService.addItemToCart(cart);
	}
	
	@DeleteMapping("/user/deleteCart/{id}")
	public void deleteCart(@PathVariable String id) {
		return productService.removeItemFromCart(id);
	}
	
	@DeleteMapping("/user/deleteallcartitems/{id}")
	public void deleteAll() {
		return productService.removeAllItemFromCart(id);
	}
}

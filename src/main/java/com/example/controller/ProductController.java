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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.ProductRepository;
import com.example.model.ProductModel;
import com.example.service.ProductService;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {

		
	@Autowired
	public ProductService productService;
        
     @GetMapping("/products")
     public List<ProductModel> getAllProducts() {
    	 return productService.getAllProducts();
     }
        
     @PostMapping("admin/addProduct")
     public boolean addProduct(@RequestBody ProductModel product) {
    	 return productService.addProduct(product);
     }
     
     @PutMapping("/admin/editProduct/{id}")
     public boolean editProduct(@PathVariable String id, @RequestBody ProductModel product) {
    	 return productService.editProduct(id, product);
     }
     
     @DeleteMapping("/admin/deleteProduct/{id}")
     public boolean deleteProduct(@PathVariable String id) {
    	 return productService.deleteProduct(id);
     }
     
     
    
}
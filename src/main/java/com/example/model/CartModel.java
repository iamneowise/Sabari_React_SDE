package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class CartModel {
	
	@Id
//	@GeneratedValue(generator = "uuid")
//	@GenericGenerator(name = "uuid", strategy = "uuid2")
	String cartId;
	String productName;
	String userId;
	String price;
	String quantity;
	
	public CartModel() {
		// TODO Auto-generated constructor stub
	}
	
	public CartModel(String productName, String userId, String price, String quantity) {
		this.productName = productName;
		this.userId = userId;
		this.price = price;
		this.quantity = quantity;
	}
	
	
	public String getCartId() {
		return cartId;
	}
	public void setCartId(String cartId) {
		this.cartId = cartId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "CartModel [cartId=" + cartId + ", productName=" + productName + ", userId=" + userId + ", price="
				+ price + ", quantity=" + quantity + "]";
	}
	
	
}

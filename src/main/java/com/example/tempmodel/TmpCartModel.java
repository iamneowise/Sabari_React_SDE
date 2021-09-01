package com.example.tempmodel;

import com.example.model.CartModel;

public class TmpCartModel {
	
	String productId;
	String productName;
	String userId;
	String price;
	String quantity;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
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
		return "tempCartModel [productId=" + productId + ", productName=" + productName + ", userId=" + userId
				+ ", price=" + price + ", quantity=" + quantity + "]";
	}
	
}

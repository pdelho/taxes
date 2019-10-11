package com.pdelho.lastminute.taxes.model;

import java.util.List;

public class Receipt {
	
	private List<Product> products;
	private String taxes;
	private String totalPrice;
	
	
	public List<Product> getProducts() {
		return products;
	}
	
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public String getTaxes() {
		return taxes;
	}
	
	public void setTaxes(String taxes) {
		this.taxes = taxes;
	}
	
	public String getTotalPrice() {
		return totalPrice;
	}
	
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}

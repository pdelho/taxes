package com.pdelho.lastminute.taxes.model;

import java.util.List;

public class Receipt {
	
	private List<Product> products;
	private Float taxes;
	private Float totalPrice;
	
	
	public List<Product> getProducts() {
		return products;
	}
	
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public Float getTaxes() {
		return taxes;
	}
	
	public void setTaxes(Float taxes) {
		this.taxes = taxes;
	}
	
	public Float getTotalPrice() {
		return totalPrice;
	}
	
	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}

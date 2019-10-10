package com.pdelho.lastminute.taxes.model;

import java.util.List;

public class Receipt {
	
	private List<Product> products;
	private Double taxes;
	private Double totalPrice;
	
	
	public List<Product> getProducts() {
		return products;
	}
	
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public Double getTaxes() {
		return taxes;
	}
	
	public void setTaxes(Double taxes) {
		this.taxes = taxes;
	}
	
	public Double getTotalPrice() {
		return totalPrice;
	}
	
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}

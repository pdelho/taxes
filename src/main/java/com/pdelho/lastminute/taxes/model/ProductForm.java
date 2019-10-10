package com.pdelho.lastminute.taxes.model;

import java.util.List;

public class ProductForm {
	
	private List<Product> products;
	
	/**
	 * Empty constructor to show in JSPs
	 */
	public ProductForm() {
		
	}

	public ProductForm(List<Product> products) {
		this.products = products;
	}



	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	
	
}

package com.pdelho.lastminute.taxes.model;

import com.pdelho.lastminute.taxes.enumerations.ProductType;

public class Product {
	
	private Integer quantity;
	private String description;
	private Float price;
	private ProductType productType;
	private boolean isImported;
	
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Float getPrice() {
		return price;
	}
	
	public void setPrice(Float price) {
		this.price = price;
	}
	
	public ProductType getProductType() {
		return productType;
	}
	
	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
	
	public boolean isImported() {
		return isImported;
	}
	
	public void setImported(boolean isImported) {
		this.isImported = isImported;
	}
	
	@Override
	public String toString()
	{
		return quantity + " product(s) " + description + " with a price of: " + price;
	}

}

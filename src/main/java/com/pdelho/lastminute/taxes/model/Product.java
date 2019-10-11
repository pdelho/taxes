package com.pdelho.lastminute.taxes.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import com.pdelho.lastminute.taxes.enumerations.ProductType;

public class Product {
	
	// Positive number
	@NotNull(message = "Enter a quantity")
	@Pattern(regexp = "[\\s]*[0-9]*[1-9]+",message="Enter a positive integer number")
	private String quantity;
	
	@NotBlank(message = "Include a description")
	private String description;
	
	@Min(value=0, message = "Enter a positive number. Decimal part must be separated with a point. Example: 2.99")
	private String price;
	
	private ProductType productType;
	
	private boolean isImported;
	
	
	public String getQuantity() {
		return quantity;
	}
	
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getPrice() {
		return price;
	}
	
	public void setPrice(String price) {
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

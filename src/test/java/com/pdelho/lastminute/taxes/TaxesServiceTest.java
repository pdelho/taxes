package com.pdelho.lastminute.taxes;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.pdelho.lastminute.taxes.enumerations.ProductType;
import com.pdelho.lastminute.taxes.model.Product;
import com.pdelho.lastminute.taxes.model.Receipt;
import com.pdelho.lastminute.taxes.service.TaxesServiceImpl;

public class TaxesServiceTest {

	TaxesServiceImpl taxesService = new TaxesServiceImpl();
	
	private static List<Product> getProductsCaseOne()
	{
		List<Product> products = new ArrayList<Product>();
		
		Product productOne = new Product();
		productOne.setQuantity("1");
		productOne.setDescription("Book");
		productOne.setPrice("12.49");
		productOne.setProductType(ProductType.BOOK);
		productOne.setImported(false);
		
		Product productTwo = new Product();
		productTwo.setQuantity("1");
		productTwo.setDescription("CD");
		productTwo.setPrice("14.99");
		productTwo.setProductType(ProductType.OTHER);
		productTwo.setImported(false);
		
		Product productThree = new Product();
		productThree.setQuantity("1");
		productThree.setDescription("Chocholate bar");
		productThree.setPrice("0.85");
		productThree.setProductType(ProductType.FOOD);
		productThree.setImported(false);
		
		products.add(productOne);
		products.add(productTwo);
		products.add(productThree);
		
		return products;	
	}
	
	private static List<Product> getProductsCaseTwo()
	{
		List<Product> products = new ArrayList<Product>();
		
		Product productOne = new Product();
		productOne.setQuantity("1");
		productOne.setDescription("Chocolates");
		productOne.setPrice("10.00");
		productOne.setProductType(ProductType.FOOD);
		productOne.setImported(true);
		
		Product productTwo = new Product();
		productTwo.setQuantity("1");
		productTwo.setDescription("Perfume");
		productTwo.setPrice("47.5");
		productTwo.setProductType(ProductType.OTHER);
		productTwo.setImported(true);
			
		products.add(productOne);
		products.add(productTwo);
		
		return products;	
	}
	
	private static List<Product> getProductsCaseThree()
	{
		List<Product> products = new ArrayList<Product>();
		
		Product productOne = new Product();
		productOne.setQuantity("1");
		productOne.setDescription("Perfume");
		productOne.setPrice("27.99");
		productOne.setProductType(ProductType.OTHER);
		productOne.setImported(true);
		
		Product productTwo = new Product();
		productTwo.setQuantity("1");
		productTwo.setDescription("Perfume");
		productTwo.setPrice("18.99");
		productTwo.setProductType(ProductType.OTHER);
		productTwo.setImported(false);
		
		Product productThree = new Product();
		productThree.setQuantity("1");
		productThree.setDescription("Headache pills");
		productThree.setPrice("9.75");
		productThree.setProductType(ProductType.MEDICAL);
		productThree.setImported(false);
		
		Product productFour = new Product();
		productFour.setQuantity("1");
		productFour.setDescription("Chocolate");
		productFour.setPrice("11.25");
		productFour.setProductType(ProductType.FOOD);
		productFour.setImported(true);
		
		
		products.add(productOne);
		products.add(productTwo);
		products.add(productThree);
		products.add(productFour);
		
		return products;	
	}
	
	@Test
	public void caseOne() {
		List<Product> products = getProductsCaseOne();
		Receipt receipt = taxesService.calculateTaxes(products);
		Product productOne = receipt.getProducts().get(0);
		assertTrue(productOne.getPrice().equals("12.49"));
		Product productTwo = receipt.getProducts().get(1);
		assertTrue(productTwo.getPrice().equals("16.49"));
		Product productThree = receipt.getProducts().get(2);
		assertTrue(productThree.getPrice().equals("0.85"));
		
		assertTrue(receipt.getTaxes().equals("1.50"));
		assertTrue(receipt.getTotalPrice().equals("29.83"));
	}
	
	@Test
	public void caseTwo() {
		List<Product> products = getProductsCaseTwo();
		Receipt receipt = taxesService.calculateTaxes(products);
		Product productOne = receipt.getProducts().get(0);
		assertTrue(productOne.getPrice().equals("10.50"));
		Product productTwo = receipt.getProducts().get(1);
		assertTrue(productTwo.getPrice().equals("54.65"));
		
		assertTrue(receipt.getTaxes().equals("7.65"));
		assertTrue(receipt.getTotalPrice().equals("65.15"));
	}
	
	@Test
	public void caseThree() {
		List<Product> products = getProductsCaseThree();
		Receipt receipt = taxesService.calculateTaxes(products);
		Product productOne = receipt.getProducts().get(0);
		assertTrue(productOne.getPrice().equals("32.19"));
		Product productTwo = receipt.getProducts().get(1);
		assertTrue(productTwo.getPrice().equals("20.89"));
		Product productThree = receipt.getProducts().get(2);
		assertTrue(productThree.getPrice().equals("9.75"));
		Product productFour = receipt.getProducts().get(3);
		assertTrue(productFour.getPrice().equals("11.85"));
		
		assertTrue(receipt.getTaxes().equals("6.70"));
		assertTrue(receipt.getTotalPrice().equals("74.68"));
	}

}

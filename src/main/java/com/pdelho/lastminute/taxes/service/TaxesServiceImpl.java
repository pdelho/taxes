package com.pdelho.lastminute.taxes.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.pdelho.lastminute.taxes.constants.TaxesConstants;
import com.pdelho.lastminute.taxes.enumerations.ProductType;
import com.pdelho.lastminute.taxes.model.Product;
import com.pdelho.lastminute.taxes.model.Receipt;

@Service
public class TaxesServiceImpl implements TaxesService {

	private static final Logger LOG = LoggerFactory.getLogger(TaxesServiceImpl.class);
	
	
	@Override
	public Receipt calculateTaxes(List<Product> products) {

		Receipt receipt = new Receipt();
		List<Product> productsReceipt = new ArrayList<Product>();
		Double taxes = 0.0;
		Double totalPrice = 0.0;
		for (Product product : products)
		{
			Double tax = this.calculateTax(product);	
			Double totalProductPrice = product.getQuantity() * product.getPrice() + tax;
			product.setPrice(totalProductPrice);
			
			// Update the receipt
			productsReceipt.add(product);
			taxes = taxes + tax;
			totalPrice = totalPrice + totalProductPrice;
		}
		receipt.setProducts(productsReceipt);
		receipt.setTaxes(taxes);
		receipt.setTotalPrice(totalPrice);
		
		return receipt;
	}
	
	protected Double calculateTax(final Product product)
	{
		Double totalTax = 0.0;
		Double unitaryTax = 0.0;
		
		// Exempt (if not imported)
		if (product.getProductType() == ProductType.BOOK || product.getProductType() == ProductType.FOOD
				|| product.getProductType() == ProductType.MEDICAL)
		{
			LOG.debug("Product {} is exempt of taxes", product.getDescription());
		}
		// General case
		else
		{
			LOG.debug("Product {} has a {}% of taxes", product.getDescription(), TaxesConstants.GENERAL_TAX * 100);
			unitaryTax = unitaryTax + TaxesConstants.GENERAL_TAX;
		}
		
		// Imported products
		if (product.isImported())
		{
			LOG.debug("Product {} was imported. Applying a {}% extra of taxes", product.getDescription(), TaxesConstants.IMPORTED_TAX*100);
			unitaryTax = unitaryTax + TaxesConstants.IMPORTED_TAX;
		}
		else
		{
			LOG.debug("Product {} was not imported", product.getDescription());
		}
		
		
		totalTax = unitaryTax * product.getQuantity() * product.getPrice();
		// Attention: the tax is rounded after calculating the total price (units times price), not each time for a product
		totalTax = Math.round(totalTax * TaxesConstants.INVERSE_ROUNDED_FACTOR) / TaxesConstants.INVERSE_ROUNDED_FACTOR;
		return totalTax;
	}

	
}

package com.pdelho.lastminute.taxes.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
		Float taxes = 0f;
		Float totalPrice = 0f;
		for (Product product : products)
		{
			
			Float tax = this.calculateTax(product);		
			Float totalProductPrice = product.getQuantity() * product.getPrice() + tax;
			
			product.setPrice(this.correctPrecission(totalProductPrice));
			
			// Update the receipt
			productsReceipt.add(product);
			taxes = taxes + tax;
			totalPrice = totalPrice + this.correctPrecission(totalProductPrice);
		}
		receipt.setProducts(productsReceipt);
		receipt.setTaxes(this.correctPrecission(taxes));
		receipt.setTotalPrice(this.correctPrecission(totalPrice));
		
		return receipt;
	}
	
	protected Float calculateTax(final Product product)
	{
		Float totalTax = 0f;
		Float unitaryTax = 0f;
		
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
		
		// Attention: the tax is rounded after calculating the total price (units times price), not each time for a product
		totalTax = unitaryTax * product.getQuantity() * product.getPrice();
		
		// The rounding rules for sales tax are that for a tax rate of n%, a shelf price of p contains (np/100 rounded up to the nearest 0.05
		totalTax = (float) (Math.ceil((totalTax / TaxesConstants.ROUNDED_FACTOR)) * TaxesConstants.ROUNDED_FACTOR);
		// totalTax = Math.round(totalTax * TaxesConstants.INVERSE_ROUNDED_FACTOR) / TaxesConstants.INVERSE_ROUNDED_FACTOR;
		
		// Warning, lost of internal precission in Java
		
		return this.correctPrecission(totalTax);
	}
	
	protected Float correctPrecission (Float decimal)
	{
		// Correct precission using BigDecimal
		BigDecimal totalTaxBD= new BigDecimal(decimal);
		totalTaxBD = totalTaxBD.setScale(2, RoundingMode.HALF_UP);
		return totalTaxBD.floatValue();
	}

	
}

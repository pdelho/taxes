package com.pdelho.lastminute.taxes.service;

import java.util.List;

import com.pdelho.lastminute.taxes.model.Product;
import com.pdelho.lastminute.taxes.model.Receipt;

public interface TaxesService {
	
	Receipt calculateTaxes (final List<Product> products);

}

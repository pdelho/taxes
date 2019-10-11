package com.pdelho.lastminute.taxes.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pdelho.lastminute.taxes.constants.ControllerConstants;
import com.pdelho.lastminute.taxes.enumerations.ProductType;
import com.pdelho.lastminute.taxes.model.ProductForm;
import com.pdelho.lastminute.taxes.model.Receipt;
import com.pdelho.lastminute.taxes.service.TaxesService;

@Controller
public class TaxesController {
	
	@Autowired
	TaxesService taxesService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showRegister(Model model) {
		return ControllerConstants.Views.INDEX;
	}
	
	@RequestMapping(value = "/receipt", method = RequestMethod.GET)
	public String showProductsForm(Model model) {
		
		final ProductForm productForm = new ProductForm();
		model.addAttribute("productForm", productForm);
		final List<ProductType> productTypes = Arrays.asList(ProductType.values());
		model.addAttribute("productTypes", productTypes);
		
		
		return ControllerConstants.Views.PRODUCTS;

	}
	
	@RequestMapping(value = "/receipt", method = RequestMethod.POST)
	public String showReceipt (Model model, @ModelAttribute("productForm") ProductForm productForm, BindingResult result) {
        if (result.hasErrors())
        {
            return ControllerConstants.Views.ERROR;
        }

        Receipt receipt = taxesService.calculateTaxes(productForm.getProducts());
        model.addAttribute(receipt);
        
		return ControllerConstants.Views.RECEIPT;

	}

}

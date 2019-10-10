package com.pdelho.lastminute.taxes.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pdelho.lastminute.taxes.enumerations.ProductType;
import com.pdelho.lastminute.taxes.model.ProductForm;

@Controller
public class TaxesController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showRegister(Model model) {
		return "index";
	}
	
	@RequestMapping(value = "/receipt", method = RequestMethod.GET)
	public String showProductsForm(Model model) {
		
		final ProductForm productForm = new ProductForm();
		model.addAttribute("productForm", productForm);
		final List<ProductType> productTypes = Arrays.asList(ProductType.values());
		model.addAttribute("productTypes", productTypes);
		
		
		return "products";

	}
	
	@RequestMapping(value = "/receipt", method = RequestMethod.POST)
	public String showReceipt (Model model, @ModelAttribute("productForm") ProductForm productForm, BindingResult result) {
        if (result.hasErrors())
        {
            return "error";
        }

		model.addAttribute("test", "Hola");
		return "receipt";

	}

}

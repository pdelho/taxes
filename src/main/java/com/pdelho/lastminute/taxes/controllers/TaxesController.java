package com.pdelho.lastminute.taxes.controllers;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pdelho.lastminute.taxes.enumerations.ProductType;
import com.pdelho.lastminute.taxes.model.ProductForm;

@Controller
public class TaxesController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showRegister(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "index";
	}
	
	@RequestMapping(value = "/receipt", method = RequestMethod.GET)
	public String showProductsForm(HttpServletRequest request, HttpServletResponse response, Model model) {
		
		final ProductForm productForm = new ProductForm();
		model.addAttribute("productForm", productForm);
		final List<ProductType> productTypes = Arrays.asList(ProductType.values());
		model.addAttribute("productTypes", productTypes);
		
		
		return "products";

	}
	
	@RequestMapping(value = "/receipt", method = RequestMethod.POST)
	public String showReceipt(HttpServletRequest request, HttpServletResponse response, Model model) {

		model.addAttribute("test", "Hola");
		return "reciept";

	}

}

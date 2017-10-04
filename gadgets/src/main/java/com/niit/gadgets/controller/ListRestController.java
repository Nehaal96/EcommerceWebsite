package com.niit.gadgets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.niit.gadgets.dao.CategoryDAO;
import com.niit.gadgets.dao.ProductDAO;
import com.niit.gadgets.dao.SupplierDAO;


@RestController
public class ListRestController 
{
	@Autowired
	private CategoryDAO category;
	
	@RequestMapping(path="/categories", method=RequestMethod.GET)
	public @ResponseBody String getAllCategories(){
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(category.getAllCategories());
    
        return json;
	}
   
	
		@Autowired
		private SupplierDAO supplier;
		
		@RequestMapping(path="/suppliers", method=RequestMethod.GET)
		public @ResponseBody String getAllsuppliers(){
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
	        String json = gson.toJson(supplier.getAllSuppliers());
	    
	        return json;
		}
	    
		@Autowired
		private ProductDAO product;
		
		@RequestMapping(path="/products", method=RequestMethod.GET)
		public @ResponseBody String getAllProducts(){
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
	        String json = gson.toJson(product.getAllProducts());
	    
	        return json;
		}
	    
	
}

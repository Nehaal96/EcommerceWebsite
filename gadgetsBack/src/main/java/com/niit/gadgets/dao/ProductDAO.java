package com.niit.gadgets.dao;

import java.util.List;

import com.niit.gadgets.model.Product;

public interface ProductDAO 
{
    public void persist(Product p);
	
	public void update(Product p);
	
	public Product  findById(int id);
	
	public void delete(Product p);
	
	public List<Product> getAllProducts();
	
	public void deleteAll();
   
    public List<Product> getFilterProducts(int C_ID);
    
}
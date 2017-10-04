package com.niit.gadgets;

import com.niit.gadgets.dao.ProductDAO;
import com.niit.gadgets.daoimpl.ProductDAOImpl;
import com.niit.gadgets.model.Product;

public class App 
{
	
	public static void main(String[] args) 
	{
		ProductDAO prodcutService=new ProductDAOImpl();
   	   	
	   	

	System.exit(0);
	}

}

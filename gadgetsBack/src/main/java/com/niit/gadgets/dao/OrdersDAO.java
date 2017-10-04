package com.niit.gadgets.dao;

import java.util.List;

import com.niit.gadgets.model.Category;
import com.niit.gadgets.model.Orders;

public interface OrdersDAO {

	 public void persist(Orders o);
		
		public void update(Orders o);
		
		public Category  findById(int id);
		
		public void delete(Orders o);
		
		public List<Orders> getAllOrders();
		
		public void deleteAll();
	
}

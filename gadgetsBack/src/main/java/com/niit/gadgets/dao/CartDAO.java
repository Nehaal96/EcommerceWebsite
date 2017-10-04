package com.niit.gadgets.dao;

import java.util.List;

import com.niit.gadgets.model.Cart;
import com.niit.gadgets.model.Product;

public interface CartDAO {

		public void save(Cart cart);
	    public Cart getId(int id);
		public void update(Cart cart);
		public void delete(Cart c);
		public List<Cart> getAll();
		public void persist(Cart c);
		public List<Cart> checkExistance(int t);
		public Cart findById(int id);
			

	
}

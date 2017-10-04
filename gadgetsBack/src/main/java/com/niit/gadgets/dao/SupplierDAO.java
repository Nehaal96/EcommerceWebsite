package com.niit.gadgets.dao;

import java.util.List;
//import com.niit.gadgets.model.Category;
import com.niit.gadgets.model.Supplier;

public interface SupplierDAO {

	 public void persist(Supplier s);
		
		public void update(Supplier s);
		
		public Supplier  findById(int id);
		
		public void delete(Supplier s);
		
		public List<Supplier> getAllSuppliers();
		
		public void deleteAll();
	
}

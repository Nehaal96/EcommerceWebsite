package com.niit.gadgets.dao;

import java.util.List;
//import com.niit.gadgets.model.Product;
import com.niit.gadgets.model.User;

public interface UserDAO 
{
public void persist(User u);
	
	public void update(User u);
	
	public User  findById(int id);
	
	public void delete(User u);
	
	public List<User> getAllUsers();
	
	public void deleteAll();


}

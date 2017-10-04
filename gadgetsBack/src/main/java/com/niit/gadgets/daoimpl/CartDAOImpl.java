package com.niit.gadgets.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.gadgets.dao.CartDAO;
import com.niit.gadgets.model.Cart;
import com.niit.gadgets.model.Product;

@Repository
public class CartDAOImpl implements CartDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	public void save(Cart cart1)
	{
		Session s=sessionFactory.openSession();
		s.beginTransaction();
		s.save(cart1);
		s.getTransaction().commit();
		s.close();
		
	}

	public Cart getId(int id) {
		
		return (Cart)sessionFactory.openSession().get(Cart.class,id);
	}

	public void delete(Cart c) {
		Session s=sessionFactory.openSession();
		s.beginTransaction();
		s.delete(c);
		s.getTransaction().commit();
		s.close();
		
	}

	public List<Cart> getAll() {
		Session s=sessionFactory.openSession();
		List<Cart> clist=s.createCriteria(Cart.class).list();
		s.close();
		return clist;
	}

	public void persist(Cart c) {
		// TODO Auto-generated method stub
		
	}
	public List<Cart> checkExistance(int pid) 
	{
        Session s=sessionFactory.openSession();		
        List<Cart> results =s.createQuery("from Cart where p_id="+pid).list();		
		s.close();
		return results;
	}


public void update(Cart p) 
	{
		Session s=sessionFactory.openSession();
		s.beginTransaction();
		s.update(p);
		s.getTransaction().commit();
		s.close();

	

	}

	public Cart findById(int id) 
	{
		
		
		return (Cart)sessionFactory.openSession().get(Cart.class,id);
	}
	      
}



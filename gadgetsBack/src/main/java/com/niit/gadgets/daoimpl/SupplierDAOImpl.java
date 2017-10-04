package com.niit.gadgets.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.gadgets.dao.SupplierDAO;
import com.niit.gadgets.model.Category;
import com.niit.gadgets.model.Supplier;

@Repository

public class SupplierDAOImpl implements  SupplierDAO{

	@Autowired
	private SessionFactory sessionFactory;
	 
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	
	public void persist(Supplier sup) {
		
		Session f=sessionFactory.openSession();
		f.beginTransaction();
		f.save(sup);
		f.getTransaction().commit();
		f.close();
		
		// TODO Auto-generated method stub
		
	}

	public void update(Supplier s) {
		// TODO Auto-generated method stub
		
	}

	public Supplier findById(int id) {
		Supplier s=(Supplier)sessionFactory.openSession().get(Supplier.class, id);
		// TODO Auto-generated method stub
		return s;
	}

	public void delete(Supplier s) {
		// TODO Auto-generated method stub
		
	}

	public List<Supplier> getAllSuppliers() {
		// TODO Auto-generated method stub
		
		Session sf =sessionFactory.openSession();
		sf.beginTransaction();
		Query query = sf.createQuery("from Supplier");
		List<Supplier> list1=query.list();
		System.out.println(list1);
		sf.getTransaction().commit();
			return list1;
		}
		
	
	

	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

}

package com.niit.gadgets.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="SUPPLIER")
public class Supplier implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="S_ID")private int s_id;
	@Column(name="S_NAME")private String s_name;
	
	@OneToMany(targetEntity=Product.class,mappedBy="supplier",cascade = CascadeType.ALL)
	private Set<Product> product;

	public Set<Product> getProduct() {
		return product;
	}

	public void setProduct(Set<Product> product) {
		this.product = product;
	}
	
	public Supplier(){
		super();
	}
	
public Supplier(int s_id, String s_name, Set<Product> product) {
	super();
	this.s_id = s_id;
	this.s_name = s_name;
	this.product = product;
}


public Supplier(int s_id, String s_name) {
	super();
	this.s_id = s_id;
	this.s_name = s_name;
}


public int getS_id() {
	return s_id;
}

public void setS_id(int s_id) {
	this.s_id = s_id;
}

public String getS_name() {
	return s_name;
}

public void setS_name(String s_name) {
	this.s_name = s_name;
}
  
  }
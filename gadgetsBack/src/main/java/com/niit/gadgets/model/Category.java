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
@Table(name="Category")
public class Category implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="C_ID")private int c_id;
	@Column(name="C_NAME")private String c_name;
	@Column(name="C_DESC")private String c_desc;	
	
	@OneToMany(targetEntity=Product.class,mappedBy = "category", cascade = CascadeType.ALL)
	private Set<Product> product;
	
	 public Set<Product> getProduct() {
			return product;
		}
		
		public void setProducts(Set<Product> product) {
			this.product = product;
		}
		public Category() {
			super();
		}

		public Category(int c_id, String c_name, String c_desc, Set<Product> product) {
			super();
			this.c_id = c_id;
			this.c_name = c_name;
			this.c_desc = c_desc;
			this.product = product;
		}
	
		public Category(int c_id, String c_name) {
			super();
			this.c_id = c_id;
			this.c_name = c_name;
		}

		public int getC_id() {
			return c_id;
		}
		
		public void setC_id(int c_id) {
			this.c_id = c_id;
		}
		
		public String getC_name() {
			return c_name;
		}
	
		public void setC_name(String c_name) {
			this.c_name = c_name;
		}
		
		public String getC_desc() {
			return c_desc;
		}
		
		public void setC_desc(String c_desc) {
			this.c_desc = c_desc;
		}
}

package com.niit.gadgets.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="U_MAIL")
	String u_mail;
	@Column(name="U_NAME")
    private String u_name;
	@Column(name="U_AGE")
	private int age;
	@Column (name="U_PHONENO")
	private String phone;
	@Column (name="U_ADDRESS")
	private String address;
	@Column(name="U_PASSWORD")
	private String u_password;
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="CART_ID")
	private Cart cart;
	@OneToMany(targetEntity=Orders.class,mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Orders> orders;
	@Column(name="ROLE")
	private String role;
	@Column(name="enabled")
	private boolean enabled;
	
	public User(String u_mail, String u_name, String u_password, Cart cart, Set<Orders> orders, String role) {
		super();
		this.u_mail = u_mail;
		this.u_name = u_name;
		this.u_password = u_password;
		this.cart = cart;
		this.orders = orders;
		this.role = role;
	}
	
	
	public boolean isEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	public User(String u_mail, String u_name, int age, String phone, String address, String u_password, String role) {
		super();
		this.u_mail = u_mail;
		this.u_name = u_name;
		this.age = age;
		this.phone = phone;
		this.address = address;
		this.u_password = u_password;
		this.role = role;
	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public User() {
		super();
	}

	public User(String u_mail, String u_name, int age, String phone, String u_password, Cart cart, Set<Orders> orders,
			String role) {
		super();
		this.u_mail = u_mail;
		this.u_name = u_name;
		this.age = age;
		this.phone = phone;
		this.u_password = u_password;
		this.cart = cart;
		this.orders = orders;
		this.role = role;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	/**
	 * @return the u_mail
	 */
	
	public String getU_mail() {
		return u_mail;
	}
	/**
	 * @param u_mail the u_mail to set
	 */
	public void setU_mail(String u_mail) {
		this.u_mail = u_mail;
	}
	/**
	 * @return the u_name
	 */
	
	public String getU_name() {
		return u_name;
	}
	/**
	 * @param u_name the u_name to set
	 */
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	/**
	 * @return the u_password
	 */
	
	public String getU_password() {
		return u_password;
	}
	/**
	 * @param u_password the u_password to set
	 */
	public void setU_password(String u_password) {
		this.u_password = u_password;
	}
	/**
	 * @return the cart_id
	 */
	
	public Cart getCart_id() {
		return cart;
	}
	/**
	 * @param cart_id the cart_id to set
	 */
	public void setCart_id(Cart cart) {
		this.cart = cart;
	}
	/**
	 * @return the orders
	 */
	
	public Set<Orders> getOrders() {
		return orders;
	}
	/**
	 * @param orders the orders to set
	 */
	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}
	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	
	

}
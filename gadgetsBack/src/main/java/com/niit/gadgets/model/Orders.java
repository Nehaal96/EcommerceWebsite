package com.niit.gadgets.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Orders
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int oId;
	private  User user;
	@Column int payment;
	@Column int orderTotal;
	public Orders(int oId, User user, int payment, int orderTotal) {
		super();
		this.oId = oId;
		this.user = user;
		this.payment = payment;
		this.orderTotal = orderTotal;
	}
	public int getoId() {
		return oId;
	}
	public void setoId(int oId) {
		this.oId = oId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	public int getOrderTotal() {
		return orderTotal;
	}
	public void setOrderTotal(int orderTotal) {
		this.orderTotal = orderTotal;
	}

	


}

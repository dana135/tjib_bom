package com.tjib.app.customer;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tjib.app.entities.Shipping;
import com.tjib.app.order.Order;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_customer")
@JsonIgnoreProperties({"cart", "orderHistory"})
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String username;
	private String password;
	private String email;
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Order> orderHistory;
	@OneToOne
	private Shipping shippingDetails;
	
	public Customer() {};
	
	public Customer(String username, String password, String email) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		orderHistory = new ArrayList<Order>();
		shippingDetails = null;
	}

	public int getId() {
		return id;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public List<Order> getOrderHistory() {
		return orderHistory;
	}

	public void setOrderHistory(List<Order> orderHistory) {
		this.orderHistory = orderHistory;
	}
	
	public void addToOrderHistory(Order order) {
		orderHistory.add(order);
	}

	public Shipping getShippingDetails() {
		return shippingDetails;
	}

	public void setShippingDetails(Shipping shippingDetails) {
		this.shippingDetails = shippingDetails;
	}
	
	

}
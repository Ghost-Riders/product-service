package com.product.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String productName;
	private int amount;

	public Product() {
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductName() {
		return productName;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", amount=" + amount + "]";
	}

}

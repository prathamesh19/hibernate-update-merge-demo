package com.prathamesh.hibernate.hibernatedemowithannotations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_info")
public class Product {
	
@Id
@Column(name="prod_id")
private int prodId;

@Column(name="prod_name")
private String prodName;

@Column(name="prod_price")
private int prodPrice;

public Product() {
	super();
	// TODO Auto-generated constructor stub
}
public Product(int prodId, String prodName, int prodPrice) {
	super();
	this.prodId = prodId;
	this.prodName = prodName;
	this.prodPrice = prodPrice;
}
@Override
public String toString() {
	return "Product [prodId=" + prodId + ", prodName=" + prodName + ", prodPrice=" + prodPrice + "]";
}
public int getProdId() {
	return prodId;
}
public void setProdId(int prodId) {
	this.prodId = prodId;
}
public String getProdName() {
	return prodName;
}
public void setProdName(String prodName) {
	this.prodName = prodName;
}
public int getProdPrice() {
	return prodPrice;
}
public void setProdPrice(int prodPrice) {
	this.prodPrice = prodPrice;
}
}

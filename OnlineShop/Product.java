package com.edu;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int pid;
	@Column(length=40,nullable = false)
	private String name;
	@Column(length=40,nullable = false)
	private float price;
	@ManyToMany(mappedBy = "pList")
	private List<Customer> cList;
	
	public List<Customer> getcList() {
		return cList;
	}

	public void setcList(List<Customer> cList) {
		this.cList = cList;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Product(String name, float price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	public int getId() {
		return pid;
	}

	public void setId(int id) {
		this.pid = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + pid + ", name=" + name + ", price=" + price + "]";
	}
}

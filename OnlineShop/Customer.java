package com.edu;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMERS")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int cid;
	@Column(length=40,nullable = false)
	private String name;
	@Column(length=40,nullable = false,unique = true)
	private String emailId;
	@Column(length=40,nullable = false)
	private String password;
	@ManyToMany
	@JoinTable(
			name = "Purchased",
			joinColumns = {@JoinColumn(name="cid")},
			inverseJoinColumns = {@JoinColumn(name="pid")}
			)
	private List<Product> pList;
	
	public List<Product> getpList() {
		return pList;
	}

	public void setpList(List<Product> pList) {
		this.pList = pList;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Customer(String name, String emailId, String password) {
		super();
		this.name = name;
		this.emailId = emailId;
		this.password = password;
	}
	
	public int getId() {
		return cid;
	}

	public void setId(int id) {
		this.cid = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + cid + ", name=" + name + ", emailId=" + emailId + ", password=" + password + "]";
	}

}

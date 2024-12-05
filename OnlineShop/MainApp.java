package com.edu;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainApp {
	public static void main(String[] args) {
		Configuration configObj=new Configuration()
				.configure()
				.addAnnotatedClass(Product.class)
				.addAnnotatedClass(Customer.class);
		SessionFactory sfObj=configObj.buildSessionFactory();
		Session sessionObj=sfObj.openSession();
		Transaction transactionObj=sessionObj.beginTransaction();
		
		Product pObj1=new Product("Pencil",10);
		//Product pObj2=new Product("Pen",20);
		Product pObj3=new Product("Eraser",5);
		//Product pObj4=new Product("Sharpner",5);
		Product pObj5=new Product("Ruler",15);
		
		List<Product> plistObj=new ArrayList<Product>();
		plistObj.add(pObj1);
		//plistObj.add(pObj2);
		plistObj.add(pObj3);
		//plistObj.add(pObj4);
		plistObj.add(pObj5);
		
		Customer cObj1=new Customer("Aman","aman@gmail.com","aman@123");
		//Customer cObj2=new Customer("Bhuvan","bh@gmail.com","bh@123");
		Customer cObj3=new Customer("Charith","ch@gmail.com","ch@123");
		//Customer cObj4=new Customer("Dev","dev@gmail.com","de@123");
		Customer cObj5=new Customer("Eshaan","es@gmail.com","es@123");
		
		List<Customer> clistObj=new ArrayList<Customer>();
		clistObj.add(cObj1);
		//clistObj.add(cObj2);
		clistObj.add(cObj3);
		//clistObj.add(cObj4);
		clistObj.add(cObj5);
		
		cObj1.setpList(plistObj);
		cObj3.setpList(plistObj);
		cObj5.setpList(plistObj);
		
		pObj1.setcList(clistObj);
		pObj3.setcList(clistObj);
		pObj5.setcList(clistObj);
		
		sessionObj.save(cObj1);
		sessionObj.save(cObj3);
		sessionObj.save(cObj5);
		sessionObj.save(pObj1);
		sessionObj.save(pObj3);
		sessionObj.save(pObj5);
		
		transactionObj.commit();
		sessionObj.close();
	}
}

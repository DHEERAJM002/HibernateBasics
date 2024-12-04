package com.edu;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration configurationObj=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.addAnnotatedClass(Department.class);
		SessionFactory sessionFactoryObj=configurationObj.buildSessionFactory();
		Session sessionObj=sessionFactoryObj.openSession();
		Transaction transactionObj=sessionObj.beginTransaction();
		Department deptObj1=new Department("IT","Bengaluru");
		Department deptObj2=new Department("Networking","Chennai");
		Employee empObj1=new Employee("Amit",50000);
		Employee empObj2=new Employee("Bhuvan",50000);
		Employee empObj3=new Employee("Charith",50000);
		Employee empObj4=new Employee("Dheeraj",50000);
		List<Employee> empList=new ArrayList<Employee>();
		empList.add(empObj1);
		empList.add(empObj2);
		empList.add(empObj3);
		empList.add(empObj4);
		deptObj1.setEmployeeList(empList);
		sessionObj.save(deptObj1);
		transactionObj.commit();
		sessionObj.close();
	}

}

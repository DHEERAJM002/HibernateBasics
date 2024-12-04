package com.edu;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Departments")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int DeptId;
	private String DeptName;
	private String Location;
	
	//One Department -> Many Employees
	@OneToMany(cascade = CascadeType.ALL)//if we save department employees will also be saved
	@JoinColumn(name = "DeptId")
	private List<Employee> employeeList=new ArrayList<Employee>();
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Department(String deptName, String location) {
		super();
		DeptName = deptName;
		Location = location;
	}
	
	public int getDeptId() {
		return DeptId;
	}
	public void setDeptId(int deptId) {
		DeptId = deptId;
	}
	public String getDeptName() {
		return DeptName;
	}
	public void setDeptName(String deptName) {
		DeptName = deptName;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public List<Employee> getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}
	@Override
	public String toString() {
		return "Department [DeptId=" + DeptId + ", DeptName=" + DeptName + ", Location=" + Location + "]";
	}
	
}

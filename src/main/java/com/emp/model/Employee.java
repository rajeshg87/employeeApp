package com.emp.model;

import com.emp.util.View;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;


public class Employee {
	
	@JsonView(View.EmployeeJsonView.class)
	@JsonProperty("id")
	int empId;
	@JsonView(View.EmployeeJsonView.class)
	@JsonProperty("name")
	String empName;
	@JsonView(View.EmployeeJsonView.class)
	@JsonProperty("desg")
	String empDesg;
	
	public Employee() {
		super();
	}

	public Employee(int empId, String empName, String empDesg) {
		this.empId = empId;
		this.empName = empName;
		this.empDesg = empDesg;
	}
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpDesg() {
		return empDesg;
	}
	public void setEmpDesg(String empDesg) {
		this.empDesg = empDesg;
	}
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName
				+ ", empDesg=" + empDesg + "]";
	}
	
	 
	
}
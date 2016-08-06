package com.emp.service;

import java.util.List;

import com.emp.model.Employee;

public interface EmployeeService {
	public List<Employee> listAllEmployee();
	public Employee getEmployeeById(int emplId);
	public Employee createEmployee(Employee employee);
	public void deleteEmployee(int empId);
}

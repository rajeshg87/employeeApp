package com.emp.dao;

import java.util.List;

import com.emp.model.Employee;

public interface EmployeeDao {
	public List<Employee> listAllEmployee();
	public Employee getEmployeeById(Integer empId);
	public Employee createEmployee(Employee employee);
	public void deleteEmployee(int empId);
}

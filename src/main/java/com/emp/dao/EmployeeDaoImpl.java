package com.emp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.emp.model.Employee;

@Component
public class EmployeeDaoImpl implements EmployeeDao{
	
	public static  Map<Integer,Employee> empMap= new HashMap<Integer, Employee>();
	
	static{
		empMap.put(1, new Employee(1, "Rajesh", "System Analyst"));
		empMap.put(2, new Employee(2, "Lenin", "System Architect"));
		empMap.put(3, new Employee(3, "Vasanth", "Project Manager"));
		empMap.put(4, new Employee(4, "Aravind", "Engineer"));
	}

	public List<Employee> listAllEmployee() {
		List<Employee> employees = empMap.entrySet().stream().map(e -> e.getValue()).collect(Collectors.toList());
		return employees;
	}

	public Employee getEmployeeById(Integer empId) {
		return empMap.entrySet().stream().filter(e -> e.getKey() == empId).findFirst().get().getValue();
	}

	@Override
	public Employee createEmployee(Employee employee) {
		int employeeId = empMap.keySet().stream().max(Integer::compareTo).orElse(0);
		empMap.put(employeeId+1, new Employee(employeeId+1,employee.getEmpName(),employee.getEmpDesg()));
		return employee;
	}

	@Override
	public void deleteEmployee(int empId) {
		empMap.remove(empId);		
	}
	
	
}

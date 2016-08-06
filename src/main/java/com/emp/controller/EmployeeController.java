package com.emp.controller;

import java.util.List;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emp.model.Employee;
import com.emp.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/getEmployeeById", method = RequestMethod.GET)	
	public @ResponseBody Employee getEmployeeById(@QueryParam("id") int id) {
		return employeeService.getEmployeeById(id);
	}
	
	@RequestMapping(value="/listAllEmployee", method = RequestMethod.GET)	
	public @ResponseBody List<Employee> listAllEmployee() {
		return employeeService.listAllEmployee();
	}
	
	@RequestMapping(value = "/createEmployee", method = RequestMethod.POST)
    public @ResponseBody Employee createUser(@RequestBody Employee employee) {
        System.out.println("Creating Employee " + employee.getEmpName()+" "+employee.getEmpDesg());
        employeeService.createEmployee(employee);
        return employee;
    }
	
	@RequestMapping(value = "/deleteEmployee/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") int id) {
        System.out.println("Fetching & Deleting Employee with id " + id);
        employeeService.deleteEmployee(id);
        return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
    }

}
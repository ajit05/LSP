package com.infosys.LSP.service;

import java.util.List;

import com.infosys.LSP.entity.Employee;



public interface EmployeeService {
	
	public List<Employee> getAllEmp();
	public Employee findById(int empid);
	public void save(Employee theEmployee);

	
}

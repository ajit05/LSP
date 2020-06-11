package com.infosys.LSP.dao;

import java.util.List;


import com.infosys.LSP.entity.Employee;



public interface EmployeeDAO {
	
	public List<Employee> getAllEmp();
	public Employee findById(int empid);
	public void save(Employee theEmployee);
	

}
 
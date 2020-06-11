package com.infosys.LSP.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infosys.LSP.dao.EmployeeDAO;
import com.infosys.LSP.entity.Employee;



@Service
public class EmployeeServiceImpl implements EmployeeService {

private EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeServiceImpl(@Qualifier("empolyeeDAOImpl")EmployeeDAO theEmployeeDAO) {
		employeeDAO = theEmployeeDAO;
		
	}

	@Override
	@Transactional	
	public List<Employee>getAllEmp() {
		
		return employeeDAO.getAllEmp();
	}

	@Override
	@Transactional
	public Employee findById(int empid) {
		// TODO Auto-generated method stub
		return employeeDAO.findById(empid);
		
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
		// TODO Auto-generated method stub
		employeeDAO.save(theEmployee);
		//return null;
	}

}

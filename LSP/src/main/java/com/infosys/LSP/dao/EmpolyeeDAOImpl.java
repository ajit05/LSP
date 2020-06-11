package com.infosys.LSP.dao;
import java.util.List;

//import javax.persistence.*; 
import javax.persistence.EntityManager;
//import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.query.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;


import com.infosys.LSP.entity.Employee;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Repository
public class EmpolyeeDAOImpl implements EmployeeDAO {
	private static final Logger LOGGER=LoggerFactory.getLogger(EmpolyeeDAOImpl.class);
	
	private EntityManager entitymanager;
	
	public EmpolyeeDAOImpl() {
		
	}
	@Autowired
	public EmpolyeeDAOImpl(EntityManager theEntityManager) {
		entitymanager = theEntityManager;
	}

	
	
	@Override
	
	public List<Employee> getAllEmp() {
		// TODO Auto-generated method stub
		/*Query theQuery= (Query) entitymanager.createQuery("from Employee");
		List<Employee> employees=theQuery.getResultList();
		return employees;*/
		
		Session  currentSession=entitymanager.unwrap(Session.class);
		Query<Employee> theQuery=currentSession.createQuery(" from Employee ",Employee.class);
		System.out.print("bfore execution");
		LOGGER.info("Simple log statement with inputs {}, {} and {}", 1,2,3);
		List<Employee> employee = theQuery.getResultList();
		System.out.print("after execution");
		
		return employee;
		
		
	}
	@Override
	/*@CacheEvict(value="twenty-second-cache", key = "'StudentInCache'+#empid",
	 beforeInvocation = true)*/
	@Cacheable(value="twenty-second-cache",key="#empid" /*ey = "'StudentInCache'+#empid"*/)	
	public Employee findById(int empid) {
		// TODO Auto-generated method stub
		Session  currentSession=entitymanager.unwrap(Session.class);
		Employee theEmployee= currentSession.get(Employee.class, empid);
		System.out.println("data bases hited...");
		LOGGER.info("data base hited........");
		return theEmployee;
		/*Employee  theEmployee= entitymanager.find(Employee.class, empid);
		return theEmployee;*/
	}
	@Override
	@CachePut(value="twenty-second-cache", key = "#theEmployee.id")
	public void save(Employee theEmployee) {
		// TODO Auto-generated method stub
		Session  currentSession=entitymanager.unwrap(Session.class);
		currentSession.saveOrUpdate(theEmployee);
		System.out.println("employedd added......");
		
	}
	

}

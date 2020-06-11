package com.infosys.LSP.rest;


import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.infosys.LSP.entity.Employee;
import com.infosys.LSP.service.EmployeeService;



@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeService  employeeService;
	public  EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService=theEmployeeService;
	}
	// expose "/employees " and return  list of employess  
	//@GetMapping("/employees")
	@RequestMapping(value = "/employee", method = RequestMethod.GET, produces = "application/json")
	public List<Employee> getAllEmp(){
		System.out.println("inside empl");
		return employeeService.getAllEmp();
	}
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployeById(@PathVariable int employeeId ) {
		Employee theEmployee=employeeService.findById(employeeId);
		if(theEmployee==null) {
			throw new RuntimeException("Employee id is not found "+employeeId);
		}
		return theEmployee;
		
	}
	@RequestMapping(value = "/employees", method = RequestMethod.PUT, produces = "application/json")
	//@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		
		theEmployee.setId(0);
		employeeService.save(theEmployee);
		return theEmployee;
		
		
	}
	
	}
	

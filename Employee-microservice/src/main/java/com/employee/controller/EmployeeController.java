package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Employee;
import com.employee.response.EmployeeResponse;
import com.employee.service.EmployeeService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

//	@PostConstruct
//	public void initValue() {
//		employeeService.initValue();
//	}

	@PostMapping("/create")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.createEmployee(employee);
	}

	
	@GetMapping("/get")
	public List<EmployeeResponse> getAllEmployee(){
		//System.out.println("get call.......................");
		List<EmployeeResponse> er= employeeService.getAllEmployee();
		if(er.size()==0) {
			System.out.println("server down");
		
			
		}
		return er;
	}

	@GetMapping("/getall")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("/hello")
	public String getTest() {
		return employeeService.getTest();
	}
	
	

}
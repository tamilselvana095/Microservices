package com.employee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.employee.Repository.EmployeeRepo;
import com.employee.dto.DepartmentDto;
import com.employee.entity.Employee;
import com.employee.feignClient.ApiClient;
import com.employee.response.EmployeeResponse;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private ApiClient apiClient;

//	public void initValue() {
//		Employee emp = new Employee();
//		emp.setName("Tamil");
//		emp.setEmail("tamil@gmail.com");
//		emp.setPhone("9089674590");
//		emp.setDepartmentCode(1l);
//
//		employeeRepo.save(emp);
//	}

	public Employee createEmployee(Employee employee) {
		return employeeRepo.save(employee);

	}

	@CircuitBreaker(name = "EMPLOYEE-MICROSERVICE", fallbackMethod = "getDefault")
	public List<EmployeeResponse> getAllEmployee() {

		List<EmployeeResponse> empList = new ArrayList<>();

		List<Employee> emp = employeeRepo.findAll();

		// System.out.println("list.........." +emp);

		// String h=apiClient.getReq();
		// System.out.println(h);

		for (Employee e : emp) {
			// System.out.println("d_code------------------ "+e.getDepartmentCode());
			DepartmentDto departmentDto = apiClient.getByCode(e.getDepartmentCode());
			// System.out.println("Department service--------------- "+departmentDto);
			EmployeeResponse empResp = new EmployeeResponse();
			empResp.setDepartmentDto(departmentDto);
			empResp.setEmployee(e);

			empList.add(empResp);
			// System.out.println("list------------------ "+empList);

		}
		return empList;
	}

	public List<Employee> getAllEmployees() {

		return employeeRepo.findAll();

	}

	@CircuitBreaker(name = "EMPLOYEE-MICROSERVICE", fallbackMethod = "getDefaultDepartment")
	public String getTest() {

		return apiClient.getReq();
	}

	public String getDefaultDepartment(Exception e) {

		return "down";
	}

	public List<EmployeeResponse> getDefault(Exception e) {

		EmployeeResponse er=new EmployeeResponse();
		
		DepartmentDto dt=new DepartmentDto();
		dt.setDepartmentCode(404l);
		dt.setDepartmentName("server down");
		dt.setLocation("india");
		
		Employee emp=new Employee();
		emp.setDepartmentCode(404l);
		emp.setEmail("aaaa@gmail.com");
		emp.setId(404l);
		emp.setName("wait");
		emp.setPhone("7845585454");
		
		er.setDepartmentDto(dt);
		er.setEmployee(emp);
		
		List<EmployeeResponse>list=new ArrayList<>();
		list.add(er);
		
		return list;
	}

	                        

}

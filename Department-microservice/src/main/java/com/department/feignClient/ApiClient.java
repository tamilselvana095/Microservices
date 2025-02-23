package com.department.feignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.department.dto.EmployeeDto;



@FeignClient(name = "EMPLOYEE-MICROSERVICE")
public interface ApiClient {
	
	@GetMapping("/employee/getall")
	public List<EmployeeDto> getAllEmployees();

}




//url = "http://localhost:8080/employee",
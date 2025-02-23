package com.employee.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import com.employee.dto.DepartmentDto;

@FeignClient(name = "DEPARTMENT-MICROSERVICE")
public interface ApiClient {
	
	@GetMapping("/department/get/{code}")
	public DepartmentDto getByCode(@PathVariable(name = "code") Long code);
		
	@GetMapping("/department/hello")
	public String getReq();

}


//url = "http://localhost:8081/department",
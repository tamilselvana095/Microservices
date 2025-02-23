package com.department.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.department.apiResponse.DepartmentResponse;
import com.department.entity.Department;
import com.department.service.DepartmentService;

import jakarta.annotation.PostConstruct;

@RefreshScope
@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@Value("${spring.boot.message}")
	private String message;
	
//	@PostConstruct
//	public void initDepartment() {
//		departmentService.initDepartment();
//	}

	@PostMapping("/create")
	public Department createDepartment(@RequestBody Department department) {
		return departmentService.createDepartment(department);
	}
	
	@GetMapping("/get")
	public List<DepartmentResponse> getAllDepartment(){
		return departmentService.getAllDepartment();
	}
	
	@GetMapping("/get/{code}")
	public Department getByCode(@PathVariable(name = "code") Long code) {
		return departmentService.getByCode(code);
	}
	
	@GetMapping("/hello")
	public String getReq() {
		return this.message;
	}
}

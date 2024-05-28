package com.department.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.department.Repository.DepartmentRepo;
import com.department.apiResponse.DepartmentResponse;
import com.department.dto.EmployeeDto;
import com.department.entity.Department;
import com.department.feignClient.ApiClient;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepo departmentRepo;

	@Autowired
	private ApiClient apiClient;

//	public void initDepartment() {
//
//		Department department = new Department();
//		department.setDepartmentName("java");
//		department.setLocation("chennai");
//		departmentRepo.save(department);
//
//	}

	public Department createDepartment(Department department) {

		return departmentRepo.save(department);
	}

	public List<DepartmentResponse> getAllDepartment() {

		List<DepartmentResponse> deptList = new ArrayList<>();

		List<Department> dept = departmentRepo.findAll();
		List<EmployeeDto> empList = apiClient.getAllEmployees();
		for (Department d : dept) {
			for (EmployeeDto ed : empList) {
				if (ed.getDepartmentCode() == d.getDepartmentCode()) {
					DepartmentResponse dr = new DepartmentResponse();
					dr.setDepartment(d);
					dr.setEmployeeDto(ed);
					deptList.add(dr);
				}
			}

		}
		return deptList;

	}

	public Department getByCode(Long code) {

		return departmentRepo.findById(code).get();
	}

}

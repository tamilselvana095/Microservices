package com.department.apiResponse;

import com.department.dto.EmployeeDto;
import com.department.entity.Department;

public class DepartmentResponse {
	
	private Department department;
	private EmployeeDto employeeDto;
	
	public DepartmentResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public EmployeeDto getEmployeeDto() {
		return employeeDto;
	}

	public void setEmployeeDto(EmployeeDto employeeDto) {
		this.employeeDto = employeeDto;
	}

	@Override
	public String toString() {
		return "DepartmentResponse [department=" + department + ", employeeDto=" + employeeDto + "]";
	}
	
	
	

}

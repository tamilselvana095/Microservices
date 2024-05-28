package com.employee.response;

import com.employee.dto.DepartmentDto;
import com.employee.entity.Employee;

public class EmployeeResponse {
	
	private Employee employee;
	private DepartmentDto departmentDto;
	
	public EmployeeResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public DepartmentDto getDepartmentDto() {
		return departmentDto;
	}

	public void setDepartmentDto(DepartmentDto departmentDto) {
		this.departmentDto = departmentDto;
	}

	@Override
	public String toString() {
		return "EmployeeResponse [employee=" + employee + ", departmentDto=" + departmentDto + "]";
	}
	
	

}

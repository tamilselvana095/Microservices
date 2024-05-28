package com.department.entity;

import java.util.List;

import com.department.dto.EmployeeDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long departmentCode;
	private String departmentName;
	private String location;
	
	
	
	

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(Long departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Department [departmentCode=" + departmentCode + ", departmentName=" + departmentName + ", location="
				+ location + "]";
	}
	
	
	
}

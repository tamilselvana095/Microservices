package com.employee.dto;

public class DepartmentDto {
	
	private Long departmentCode;
	private String departmentName;
	private String Location;
	

	public DepartmentDto() {
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
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	@Override
	public String toString() {
		return "Department [departmentCode=" + departmentCode + ", departmentName=" + departmentName + ", Location="
				+ Location + "]";
	}
	

}

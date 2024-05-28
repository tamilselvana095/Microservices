package com.department.dto;

public class EmployeeDto {

	private Long id;
	private String name;
	private String email;
	private String phone;
	private Long departmentCode;
	
	public EmployeeDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	

	public Long getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(Long departmentCode) {
		this.departmentCode = departmentCode;
	}

	@Override
	public String toString() {
		return "EmployeeDto [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone
				+ ", departmentCode=" + departmentCode + "]";
	}
	
	
	
}

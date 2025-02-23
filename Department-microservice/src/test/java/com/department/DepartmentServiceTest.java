package com.department;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.department.Repository.DepartmentRepo;
import com.department.apiResponse.DepartmentResponse;
import com.department.dto.EmployeeDto;
import com.department.entity.Department;
import com.department.feignClient.ApiClient;
import com.department.service.DepartmentService;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {

	@Mock
	private DepartmentRepo departmentRepo;

	@Mock
	private ApiClient apiClient;

	@InjectMocks
	private DepartmentService departmentService;

//	@BeforeEach
//	public void init() {
//		MockitoAnnotations.initMocks(this);
//	}

	@Test
	public void testCreateDepartment() {
		// Mocking behavior of DepartmentRepo to return a created department
		Department mockDepartment = new Department();
		mockDepartment.setDepartmentName("Test Department");
		mockDepartment.setLocation("Test Location");
		when(departmentRepo.save(any(Department.class))).thenReturn(mockDepartment);

		// Creating a department
		Department department = new Department();
		department.setDepartmentName("Test Department");
		department.setLocation("Test Location");

		// Calling service method
		Department createdDepartment = departmentService.createDepartment(department);

		// Assertions
		Assertions.assertNotNull(createdDepartment);
		Assertions.assertEquals("Test Department", createdDepartment.getDepartmentName());
		Assertions.assertEquals("Test Location", createdDepartment.getLocation());
	}

	@Test
	public void testGetAllDepartment() {
		// Mock data
		Department mockDepartment = new Department();
		mockDepartment.setDepartmentCode(1L);
		mockDepartment.setDepartmentName("Test Department");
		mockDepartment.setLocation("Test Location");
		List<Department> mockDepartments = new ArrayList<>();
		mockDepartments.add(mockDepartment);

		EmployeeDto mockEmployeeDto = new EmployeeDto();
		mockEmployeeDto.setDepartmentCode(1L);
		mockEmployeeDto.setName("Test Employee");

		List<EmployeeDto> mockEmployeeDtoList = new ArrayList<>();
		mockEmployeeDtoList.add(mockEmployeeDto);

		// Mocking behavior of DepartmentRepo to return mock departments
		when(departmentRepo.findAll()).thenReturn(mockDepartments);
		// Mocking behavior of ApiClient to return mock employee DTOs
		when(apiClient.getAllEmployees()).thenReturn(mockEmployeeDtoList);

		// Calling service method
		List<DepartmentResponse> departmentResponses = departmentService.getAllDepartment();

		// Assertions
		Assertions.assertEquals(1, departmentResponses.size());
		DepartmentResponse departmentResponse = departmentResponses.get(0);
		Assertions.assertEquals("Test Department", departmentResponse.getDepartment().getDepartmentName());
		Assertions.assertEquals("Test Location", departmentResponse.getDepartment().getLocation());
		Assertions.assertEquals("Test Employee", departmentResponse.getEmployeeDto().getName());
		// Add more assertions as needed
	}

	@Test
	public void testGetByCode() {
		// Mock data
		Department mockDepartment = new Department();
		mockDepartment.setDepartmentCode(1L);
		mockDepartment.setDepartmentName("Test Department");
		mockDepartment.setLocation("Test Location");

		// Mocking behavior of DepartmentRepo to return mock department by code
		when(departmentRepo.findById(1L)).thenReturn(Optional.of(mockDepartment));

		// Calling service method
		Department department = departmentService.getByCode(1L);

		// Assertions
		Assertions.assertNotNull(department);
		Assertions.assertEquals("Test Department", department.getDepartmentName());
		Assertions.assertEquals("Test Location", department.getLocation());
		// Add more assertions as needed
	}

}

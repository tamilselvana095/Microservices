package com.employee;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.employee.Repository.EmployeeRepo;
import com.employee.dto.DepartmentDto;
import com.employee.entity.Employee;
import com.employee.feignClient.ApiClient;
import com.employee.response.EmployeeResponse;
import com.employee.service.EmployeeService;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

	@Mock
	private EmployeeRepo employeeRepo;

	@Mock
	private ApiClient apiClient;

	@InjectMocks
	private EmployeeService employeeService;

//	@BeforeEach
//	public void init() {
//		MockitoAnnotations.initMocks(this);
//	}

	@Test
	public void testCreateEmployee() {
		Employee mockEmployee = new Employee();
		mockEmployee.setName("Test Employee");
		mockEmployee.setEmail("test@example.com");
		mockEmployee.setPhone("1234567890");
		mockEmployee.setDepartmentCode(1L);

		when(employeeRepo.save(any(Employee.class))).thenReturn(mockEmployee);

		Employee createdEmployee = employeeService.createEmployee(mockEmployee);

		Assertions.assertEquals("Test Employee", createdEmployee.getName());
		Assertions.assertEquals("test@example.com", createdEmployee.getEmail());
		Assertions.assertEquals("1234567890", createdEmployee.getPhone());
		Assertions.assertEquals(1L, createdEmployee.getDepartmentCode());
	}

	 @Test
	    public void testCreateEmployeeFailure() {
	        // Mocking behavior of EmployeeRepo to throw an exception
	        when(employeeRepo.save(any(Employee.class))).thenThrow(new RuntimeException("Failed to save employee"));

	        // Creating a new employee
	        Employee employee = new Employee();
	        employee.setName("John Doe");

	        // Asserting that the service method throws an exception
	        Assertions.assertThrows(RuntimeException.class, () -> {
	            employeeService.createEmployee(employee);
	        });
	    }
	 
	@Test
	public void testGetAllEmployee() {
		// Mock data
		Employee mockEmployee = new Employee();
		mockEmployee.setName("Test Employee");
		mockEmployee.setEmail("test@example.com");
		mockEmployee.setPhone("1234567890");
		mockEmployee.setDepartmentCode(1L);

		DepartmentDto mockDepartmentDto = new DepartmentDto();
		mockDepartmentDto.setDepartmentCode(1L);
		mockDepartmentDto.setDepartmentName("Test Department");
		mockDepartmentDto.setLocation("Test Location");

		List<Employee> mockEmployeeList = new ArrayList<>();
		mockEmployeeList.add(mockEmployee);

		when(employeeRepo.findAll()).thenReturn(mockEmployeeList);
		when(apiClient.getByCode(anyLong())).thenReturn(mockDepartmentDto);

		// Call service method
		List<EmployeeResponse> employeeResponses = employeeService.getAllEmployee();

		// Assertions
		Assertions.assertEquals(1, employeeResponses.size());
		EmployeeResponse employeeResponse = employeeResponses.get(0);
		Assertions.assertEquals("Test Employee", employeeResponse.getEmployee().getName());
		Assertions.assertEquals("test@example.com", employeeResponse.getEmployee().getEmail());
		Assertions.assertEquals("1234567890", employeeResponse.getEmployee().getPhone());
		Assertions.assertEquals("Test Department", employeeResponse.getDepartmentDto().getDepartmentName());
		Assertions.assertEquals("Test Location", employeeResponse.getDepartmentDto().getLocation());
	}

}

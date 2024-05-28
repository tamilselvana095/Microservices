package com.employee;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.employee.controller.EmployeeController;
import com.employee.entity.Employee;
import com.employee.response.EmployeeResponse;
import com.employee.service.EmployeeService;

@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest {

	@Mock
	private EmployeeService employeeService;

	@InjectMocks
	private EmployeeController employeeController;

//	@BeforeEach
//	public void init() {
//		MockitoAnnotations.initMocks(this);
//	}

	@Test
	public void testCreateEmployeeSuccess() {
		// Mocking behavior of EmployeeService to return a created employee
		Employee mockEmployee = new Employee();
		mockEmployee.setName("Test Employee");
		mockEmployee.setEmail("test@example.com");
		mockEmployee.setPhone("1234567890");
		mockEmployee.setDepartmentCode(1L);
		when(employeeService.createEmployee(any(Employee.class))).thenReturn(mockEmployee);

		// Creating an employee
		Employee employee = new Employee();
		employee.setName("John Doe");

		// Calling controller method
		Employee createdEmployee = employeeController.createEmployee(employee);

		// Assertions
		Assertions.assertNotNull(createdEmployee);
		Assertions.assertEquals("Test Employee", createdEmployee.getName());
		Assertions.assertEquals("test@example.com", createdEmployee.getEmail());
		Assertions.assertEquals("1234567890", createdEmployee.getPhone());
		Assertions.assertEquals(1L, createdEmployee.getDepartmentCode());
	}

	@Test
	public void testGetAllEmployeeSuccess() {
		// Mocking behavior of EmployeeService to return a list of employee responses
		List<EmployeeResponse> mockEmployeeResponses = new ArrayList<>();
		EmployeeResponse mockEmployeeResponse = new EmployeeResponse();
		// Set mock data for employee response
		mockEmployeeResponses.add(mockEmployeeResponse);
		when(employeeService.getAllEmployee()).thenReturn(mockEmployeeResponses);

		// Calling controller method
		List<EmployeeResponse> employeeResponses = employeeController.getAllEmployee();

		// Assertions
		Assertions.assertEquals(1, employeeResponses.size());
		// Add more assertions as needed
	}

}

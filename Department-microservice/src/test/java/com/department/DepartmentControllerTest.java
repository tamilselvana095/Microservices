package com.department;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.department.apiResponse.DepartmentResponse;
import com.department.controller.DepartmentController;
import com.department.entity.Department;
import com.department.service.DepartmentService;

public class DepartmentControllerTest {
	
	@Mock
    private DepartmentService departmentService;

    @InjectMocks
    private DepartmentController departmentController;

//    @BeforeEach
//    public void init() {
//        MockitoAnnotations.initMocks(this);
//    }

    @Test
    public void testCreateDepartment() {
        // Mocking behavior of DepartmentService to return a created department
        Department mockDepartment = new Department();
        mockDepartment.setDepartmentName("Test Department");
        mockDepartment.setLocation("Test Location");
        when(departmentService.createDepartment(any(Department.class))).thenReturn(mockDepartment);

        // Creating a department
        Department department = new Department();
        department.setDepartmentName("Test Department");
        department.setLocation("Test Location");

        // Calling controller method
        Department createdDepartment = departmentController.createDepartment(department);

        // Assertions
        Assertions.assertNotNull(createdDepartment);
        Assertions.assertEquals("Test Department", createdDepartment.getDepartmentName());
        Assertions.assertEquals("Test Location", createdDepartment.getLocation());
    }

    @Test
    public void testGetAllDepartment() {
        // Mocking behavior of DepartmentService to return a list of department responses
        List<DepartmentResponse> mockDepartmentResponses = new ArrayList<>();
        DepartmentResponse mockDepartmentResponse = new DepartmentResponse();
        // Set mock data for department response
        mockDepartmentResponses.add(mockDepartmentResponse);
        when(departmentService.getAllDepartment()).thenReturn(mockDepartmentResponses);

        // Calling controller method
        List<DepartmentResponse> departmentResponses = departmentController.getAllDepartment();

        // Assertions
        Assertions.assertEquals(1, departmentResponses.size());
        // Add more assertions as needed
    }

    @Test
    public void testGetByCode() {
        // Mock data
        Department mockDepartment = new Department();
        mockDepartment.setDepartmentCode(1L);
        mockDepartment.setDepartmentName("Test Department");
        mockDepartment.setLocation("Test Location");

        // Mocking behavior of DepartmentService to return mock department by code
        when(departmentService.getByCode(1L)).thenReturn(mockDepartment);

        // Calling controller method
        Department department = departmentController.getByCode(1L);

        // Assertions
        Assertions.assertNotNull(department);
        Assertions.assertEquals("Test Department", department.getDepartmentName());
        Assertions.assertEquals("Test Location", department.getLocation());
        // Add more assertions as needed
    }

//    @Test
//    public void testGetReq() {
//        // Mocking the value of message
//        String mockMessage = "Hello, world!";
//        departmentController.setMessage(mockMessage);
//
//        // Calling controller method
//        String message = departmentController.getReq();
//
//        // Assertions
//        Assertions.assertEquals(mockMessage, message);
//    }

}

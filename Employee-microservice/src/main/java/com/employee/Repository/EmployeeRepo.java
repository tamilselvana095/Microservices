package com.employee.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

	public List<Employee> findByDepartmentCode(Long departmentCode);
}

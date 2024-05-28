package com.department.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.department.entity.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {

}

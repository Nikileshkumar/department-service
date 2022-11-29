package com.encora.departmet.repository;

import com.encora.departmet.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department, String> {
    Department findByDepartmentName(String departmentName);
}

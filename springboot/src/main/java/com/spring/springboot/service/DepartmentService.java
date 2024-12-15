package com.spring.springboot.service;

import com.spring.springboot.entity.Department;
import com.spring.springboot.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> fetchAllDepartments();

    Department fetchDepartment(Long id) throws DepartmentNotFoundException;

    void deleteDepartment(Long id);

    Department updateDepartment(Department department, Long id);

    List<Department> fetchDepartment(String name);
}

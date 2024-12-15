package com.spring.springboot.repository;

import com.spring.springboot.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // This annotation is used to tell spring that this class is the repository/data control layer for the given type
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    List<Department> findByDeptNameIgnoreCase(String deptName);
}

package com.spring.springboot.service;

import com.spring.springboot.entity.Department;
import com.spring.springboot.error.DepartmentNotFoundException;
import com.spring.springboot.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // This annotation is used to tell the spring that this class is a service layer
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> fetchAllDepartments() {
        return this.departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartment(Long id) throws DepartmentNotFoundException {
        Optional<Department> department = this.departmentRepository.findById(id);

        if (department.isEmpty()) {
            throw new DepartmentNotFoundException("Department Not Available");
        }

        return department.get();
    }

    @Override
    public List<Department> fetchDepartment(String name) {
        return this.departmentRepository.findByDeptNameIgnoreCase(name);
    }

    @Override
    public Department saveDepartment(Department department) {
        return this.departmentRepository.save(department);
    }

    @Override
    public Department updateDepartment(Department department, Long id) {
        Department existingDepartment = this.departmentRepository.findById(id).isPresent() ? this.departmentRepository.findById(id).get() : null;

        if (existingDepartment == null) {
            return null;
        }

        if (department.getDeptName() != null && !department.getDeptName().isEmpty()) {
            existingDepartment.setDeptName(department.getDeptName());
        }

        if (department.getDeptAddress() != null && !department.getDeptAddress().isEmpty()) {
            existingDepartment.setDeptAddress(department.getDeptAddress());
        }

        if (department.getDeptCode() != null && !department.getDeptCode().isEmpty()) {
            existingDepartment.setDeptCode(department.getDeptCode());
        }

        return this.departmentRepository.save(existingDepartment);
    }

    @Override
    public void deleteDepartment(Long id) {
        this.departmentRepository.deleteById(id);
    }

}

package com.spring.springboot.controller;

import com.spring.springboot.entity.Department;
import com.spring.springboot.error.DepartmentNotFoundException;
import com.spring.springboot.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // This annotation is used to tell spring that this class is a rest api controller
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired // This annotation is used to autowire the dependency to the below data member
    private DepartmentService departmentService;

    // Loggers are used to debug/print on console while the application is running
    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @GetMapping
    public List<Department> fetchAllDepartments() {
        LOGGER.info("Departments has been fetched");
        return this.departmentService.fetchAllDepartments();
    }

    @GetMapping("/id/{id}")
    public Department fetchDepartment(@PathVariable Long id) throws DepartmentNotFoundException {
        return this.departmentService.fetchDepartment(id);
    }

    @GetMapping("/name/{name}")
    public List<Department> fetchDepartment(@PathVariable String name) {
        return this.departmentService.fetchDepartment(name);
    }

    @PostMapping
    public Department saveDepartment(@Valid @RequestBody Department department) {
        return this.departmentService.saveDepartment(department);
    }

    @PutMapping("/{id}")
    public Department updateDepartment(@RequestBody Department department, @PathVariable Long id) {
        return this.departmentService.updateDepartment(department, id);
    }

    @DeleteMapping("/{id}")
    public String deleteDepartment(@PathVariable Long id) {
        this.departmentService.deleteDepartment(id);
        return "Department deleted successfully";
    }

}

package com.spring.springboot.service;

import com.spring.springboot.entity.Department;
import com.spring.springboot.error.DepartmentNotFoundException;
import com.spring.springboot.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    DepartmentService departmentService;

    @MockitoBean
    DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .deptId(1L)
                .deptName("CS")
                .deptAddress("Chennai")
                .deptCode("CS08")
                .build();

        Mockito.when(departmentRepository.findById(1L)).thenReturn(Optional.ofNullable(department));
    }

    @Test
    @DisplayName("Getting data based on valid department id")
    void whenAValidDeptIdIsUsedToCall_ThenAValidDeptShouldBeReturned() throws DepartmentNotFoundException {
        Long deptID = 1L;
        Department found = departmentService.fetchDepartment(deptID);
        assertEquals(deptID, found.getDeptId());
    }
}
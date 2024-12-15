package com.spring.springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long deptId;

    @NotBlank(message = "Please enter a deptName")
    @Size(min = 2, message = "Dept size shouldn't be lesser than 2 characters")
    @Size(max = 5, message = "Dept size shouldn't exceed 5 characters")
    private String deptName;
    private String deptAddress;
    private String deptCode;
}

package com.simple.com.componentscan.withannotations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Employee {
    @Value("1")
    private int emloyeeId;
    @Value("Abubakker")
    private String firstName;
    @Value("Siddik")
    private String lastName;
    @Value("50000")
    private int salary;

    public int getEmloyeeId() {
        return emloyeeId;
    }

    public void setEmloyeeId(int emloyeeId) {
        this.emloyeeId = emloyeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [emloyeeId=" + emloyeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", salary="
                + salary + "]";
    }
}

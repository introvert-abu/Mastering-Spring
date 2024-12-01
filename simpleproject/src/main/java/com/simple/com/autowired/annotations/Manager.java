package com.simple.com.autowired.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Manager {
    @Autowired
    @Qualifier("employee")
    private Employee employee;

    /*
     @Autowired
    public Manager(Employee employee) {
        this.employee = employee;
    }
    */ 

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Manager [employee=" + employee + "]";
    }
}

package com.simple.com.componentscan.withxml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext("componentscan.xml");

        Employee employee = context.getBean("employee", Employee.class);
        System.out.println(employee.toString());
        Car myCar = context.getBean("car", Car.class);
        System.out.println(myCar.toString());
    }
}

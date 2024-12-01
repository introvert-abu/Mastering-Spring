package com.simple.com.componentscan.withannotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Employee employee = context.getBean("employee", Employee.class);
        System.out.println(employee.toString());
        Car myCar = context.getBean("car", Car.class);
        System.out.println(myCar.toString());
    }
}

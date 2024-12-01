package com.simple.com.setter.injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationSetterInjection.xml");

        Car myCar = (Car) context.getBean("myCar");
        myCar.displayDetails();
    }
}

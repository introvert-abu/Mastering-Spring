package com.simple.com.loose.coupling;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationLooseCoupling.xml");

        DataProvider data1 = (DataProvider) context.getBean("db1");
        data1.showDetails();
        DataProvider data2 = (DataProvider) context.getBean("db2");
        data2.showDetails();
    }
}

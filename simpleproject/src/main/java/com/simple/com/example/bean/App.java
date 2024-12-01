package com.simple.com.example.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationBeanContext.xml");

        Mybean mybean = (Mybean) context.getBean("myBean");
        System.out.println(mybean);
    }
}

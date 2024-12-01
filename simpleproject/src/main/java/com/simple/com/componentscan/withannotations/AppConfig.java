package com.simple.com.componentscan.withannotations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.simple.com.componentscan.withannotations")
public class AppConfig {
}

package com.simple.com.autowired.annotations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.simple.com.autowired.annotations")
public class AppConfig {
}

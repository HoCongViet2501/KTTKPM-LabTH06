package com.se.springboot_activemq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SpringbootActivemqApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(SpringbootActivemqApplication.class, args);
    }
    
}

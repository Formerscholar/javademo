package com.chad.ademo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@MapperScan("com.chad.ademo.mapper")
@EnableGlobalMethodSecurity(
	securedEnabled = true,
	prePostEnabled = true
)
public class AdamoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(AdamoApplication.class, args);
	}
	
}

package com.chad.ademo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.chad.ademo.mapper")
public class AdamoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(AdamoApplication.class, args);
	}
	
}

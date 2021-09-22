package com.chad.aopdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.chad.aopdemo.mapper")
public class AopdemoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}
	
}

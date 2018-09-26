package com.fast.family.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@ComponentScan("com.fast.family")
@MapperScan(basePackages = "com.fast.family.example.mapper")
@SpringBootApplication
public class FastFamilyExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(FastFamilyExampleApplication.class, args);
	}
}

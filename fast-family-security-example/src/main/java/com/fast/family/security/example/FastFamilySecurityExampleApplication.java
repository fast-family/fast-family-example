package com.fast.family.security.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;


@MapperScan("com.fast.family.security.example.mapper")
@SpringBootApplication
public class FastFamilySecurityExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(FastFamilySecurityExampleApplication.class, args);
	}
}

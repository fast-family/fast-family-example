package com.fast.family.datasource.example;

import com.fast.family.datasource.DynamicDataSourceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("com.fast.family")
@SpringBootApplication
public class FastFamilyDatasourceExampleApplication {

	@Autowired
	private DynamicDataSourceProperties properties;


	@GetMapping("/helloword")
	public void helloword(){
		System.out.println(properties);
	}

	public static void main(String[] args) {
		SpringApplication.run(FastFamilyDatasourceExampleApplication.class, args);
	}
}

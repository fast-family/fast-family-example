package com.fast.family.mvc.example;

import com.fast.family.mvc.filter.AccessLogFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

import javax.servlet.Filter;

@Configuration
@MapperScan("com.fast.family.mvc.example.mapper")
@SpringBootApplication
public class FastFamilyMvcExampleApplication {

	@Bean
	public Filter logFilter(){
		return new AccessLogFilter();
	}

	public static void main(String[] args) {
		SpringApplication.run(FastFamilyMvcExampleApplication.class, args);
	}
}

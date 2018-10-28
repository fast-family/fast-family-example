package com.fast.family.mvc.example;

import com.fast.family.log.aop.AccessLogMethodInterceptor;
import com.fast.family.log.aop.AccessLogPointcutAdvisor;
import com.fast.family.mvc.example.controller.HelloWord;
import com.fast.family.mvc.filter.AccessLogFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;
import tk.mybatis.spring.annotation.MapperScan;

import javax.servlet.Filter;

@Order(1)
@EnableAspectJAutoProxy
@Configuration
@MapperScan("com.fast.family.mvc.example.mapper")
@ComponentScan("com.fast.family")
@SpringBootApplication
public class FastFamilyMvcExampleApplication {

//	@Bean
//	public Filter logFilter(){
//		return new AccessLogFilter();
//	}





	public static void main(String[] args) {
		SpringApplication.run(FastFamilyMvcExampleApplication.class, args);
	}
}

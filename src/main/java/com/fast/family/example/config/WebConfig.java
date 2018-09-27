package com.fast.family.example.config;


import com.fast.family.mvc.filter.AccessLogFilter;
import com.fast.family.security.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.zalando.problem.ProblemModule;
import org.zalando.problem.validation.ConstraintViolationProblemModule;

import javax.servlet.Filter;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.Set;

/**
 * @author 张顺
 * @version 1.0
 * @created 2018/9/21-23:11
 */
@Configuration
public class WebConfig implements ServletContainerInitializer{

    @Autowired
    private SecurityProperties securityProperties;

    @Bean
    public ProblemModule problemModule() {
        return new ProblemModule();
    }

    @Bean
    public ConstraintViolationProblemModule constraintViolationProblemModule() {
        return new ConstraintViolationProblemModule();
    }

    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = securityProperties.getCors();
        if (corsConfiguration.getAllowedOrigins() != null &&
                !corsConfiguration.getAllowedOrigins().isEmpty()){
            source.registerCorsConfiguration("/**",corsConfiguration);
        }
        return new CorsFilter(source);
    }

    @Bean
    public Filter accessLogFilter(){
        return new AccessLogFilter();
    }

    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {

    }
}

package com.fast.family.mvc.example.config;

import com.fast.family.log.aop.AccessLogMethodInterceptor;
import com.fast.family.mvc.example.interceptor.SimpleInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 张顺
 * @version 1.0
 */
@Configuration
public class WebConfig {

    @Bean
    public AccessLogMethodInterceptor accessLogMethodInterceptor(){
        AccessLogMethodInterceptor accessLogMethodInterceptor =
                new AccessLogMethodInterceptor();
        accessLogMethodInterceptor.add(new SimpleInterceptor());
        return accessLogMethodInterceptor;
    }
}

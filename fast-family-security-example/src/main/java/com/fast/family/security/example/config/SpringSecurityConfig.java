package com.fast.family.security.example.config;

import com.fast.family.security.SecurityProperties;
import com.fast.family.security.jwt.JWTConfigurer;
import com.fast.family.security.jwt.JWTHelper;
import com.fast.family.security.mobile.SmsCodeAuthenticationConfigurer;
import com.fast.family.security.validate.code.ImMemoryValidateCodeRepository;
import com.fast.family.security.validate.code.ValidateCodeGenerator;
import com.fast.family.security.validate.code.ValidateCodeRepository;
import com.fast.family.security.validate.code.image.ImageValidateCodeGenerator;
import com.fast.family.security.validate.code.sms.SmsValidateCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.filter.CorsFilter;

/**
 * @author 张顺
 * @version 1.0
 * @created 2018/10/8-9:56
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private JWTHelper jwtHelper;

    @Autowired
    private SecurityProperties securityProperties;



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf()
            .disable()
            .headers()
            .frameOptions()
            .disable()
        .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
            .authorizeRequests()
            .antMatchers("/index").permitAll()
        .and()
            .apply(jwtConfigurer());

    }

    /**
     * jwt配置
     * @return
     */
    private JWTConfigurer jwtConfigurer(){
        return new JWTConfigurer(jwtHelper,securityProperties);
    }

    /**
     * 短信验证码配置
     * @return
     */
    private SmsCodeAuthenticationConfigurer smsCodeAuthenticationConfigurer(){
        return new SmsCodeAuthenticationConfigurer();
    }
}

package com.fast.family.security.example.config;

import com.fast.family.security.SecurityProperties;
import com.fast.family.security.example.service.impl.UserDetailsServiceImpl;
import com.fast.family.security.jwt.JWTConfigurer;
import com.fast.family.security.jwt.JWTHelper;
import com.fast.family.security.mobile.SmsCodeAuthenticationConfigurer;
import com.fast.family.security.validate.code.sms.SmsValidateCodeConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.annotation.PostConstruct;

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

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManagerBuilder authenticationManagerBuilder;


    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


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
            .antMatchers("/system/index").permitAll()
        .and()
            .apply(jwtConfigurer())
        .and()
            .apply(smsCodeAuthenticationConfigurer())
        .and()
            .apply(smsValidateCodeConfigurer());

    }


    private SmsValidateCodeConfigurer smsValidateCodeConfigurer(){
        return new SmsValidateCodeConfigurer();
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
        return new SmsCodeAuthenticationConfigurer(userDetailsService);
    }
}

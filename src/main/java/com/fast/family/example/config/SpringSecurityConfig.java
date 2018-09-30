package com.fast.family.example.config;

import com.fast.family.security.SecurityProperties;
import com.fast.family.security.ip.CustomIpAuthencationProvider;
import com.fast.family.security.jwt.JWTConfigurer;
import com.fast.family.security.jwt.JWTHelper;
import com.fast.family.security.mobile.SmsCodeAuthenticationConfigure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.annotation.PostConstruct;

/**
 * @author 张顺
 * @version 1.0
 * @created 2018/9/24-13:17
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManagerBuilder authenticationManagerBuilder;

    @Autowired
    private AuthenticationFailureHandler customAuthenticationFailureHandler;

    @Autowired
    private AuthenticationSuccessHandler customAuthenticationSuccessHandler;

    @Autowired
    private LogoutSuccessHandler customLogoutSuccessHandler;

    @Autowired
    private CorsFilter corsFilter;

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private JWTHelper jwtHelper;

    @Autowired
    private CustomIpAuthencationProvider customIpAuthencationProvider;

    @PostConstruct
    public void init(){
        try {
            authenticationManagerBuilder.userDetailsService(userDetailsService);
            authenticationManagerBuilder.authenticationProvider(customIpAuthencationProvider);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .addFilterBefore(corsFilter, UsernamePasswordAuthenticationFilter.class)
            .exceptionHandling()
        .and()
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
            .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
            .antMatchers("/login").permitAll()
            .antMatchers("/v2/api-docs/**").permitAll()
            .antMatchers("/swagger-ui/index.html").permitAll()
            .antMatchers("/swagger-resources/configuration/ui").permitAll()
        .and()
            .userDetailsService(userDetailsService)
            .apply(jwtConfigurer())
        .and()
            .apply(smsCodeAuthenticationConfigure());
    }


    private SmsCodeAuthenticationConfigure smsCodeAuthenticationConfigure(){
        return new SmsCodeAuthenticationConfigure();
    }

    private JWTConfigurer jwtConfigurer(){
        return new JWTConfigurer(jwtHelper,securityProperties);
    }
}

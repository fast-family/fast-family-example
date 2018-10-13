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
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
    }
//
//    /**
//     * 配置验证码存储方式
//     * @return
//     */
//    @Bean
//    public ValidateCodeRepository validateCodeRepository(){
//        return new ImMemoryValidateCodeRepository();
//    }
//
//    /**
//     * 图片验证码
//     * @return
//     */
//    @Bean
//    public ValidateCodeGenerator imageValidateCodeGenerator(){
//        return new ImageValidateCodeGenerator();
//    }
//
//    /**
//     * 短信验证码
//     * @return
//     */
//    @Bean
//    public ValidateCodeGenerator smsValidateCodeGenerator(){
//        return new SmsValidateCodeGenerator();
//    }


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

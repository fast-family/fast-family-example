package com.fast.family.example.config;

import com.github.zs.lqh.mapper.helper.CustomMapperHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

@Configuration
public class MybatisAutoConfigure {

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setMapperHelper(new CustomMapperHelper());
        mapperScannerConfigurer.setBasePackage("com.fast");
        return mapperScannerConfigurer;
    }
}

package com.fast.family.mvc.example;

import com.fast.family.generator.MainGenerator;
import com.fast.family.generator.config.GeneratorConfig;

import java.io.IOException;

/**
 * @author 张顺
 * @version 1.0
 * @created 2018/10/6-14:18
 */
public class GeneratorCode {


    public static void main(String[] args) throws IOException {

        /**
         * 1.类名称
         * 2.类描述
         * 3.类路径
         * 4.表名
         * 5.全局配置信息
         */
        MainGenerator.generatorCode( "SysUser",
                "用户信息", "user",
                "sys_user", generatorConfig());
    }

    private static GeneratorConfig generatorConfig(){
        GeneratorConfig generatorConfig = new GeneratorConfig();
        generatorConfig.setDbHost("localhost");
        generatorConfig.setDbName("fast-family-example");
        generatorConfig.setDbPassword("root");
        generatorConfig.setDbUser("root");
        generatorConfig.setPort(3306);
        generatorConfig.setPackageName("com.fast.family.mvc.example");
        generatorConfig.setSrcBasePath("F://github//fast-family-example//fast-family-mvc-example//src//main//java//com//fast//family//mvc//example//");
        return generatorConfig;
    }
}

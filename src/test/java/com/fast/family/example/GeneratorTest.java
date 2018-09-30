package com.fast.family.example;

import com.fast.family.generator.MainGenerator;
import com.fast.family.generator.config.GeneratorConfig;

/**
 * @author 张顺
 * @version 1.0
 * @created 2018/9/29-13:27
 */
public class GeneratorTest {

    public static void main(String[] args) {

        MainGenerator.generatorCode( "SysUser",
                "用户信息", "user", "sys_user",
                generatorConfig());
    }

    private static GeneratorConfig generatorConfig(){
        GeneratorConfig generatorConfig = new GeneratorConfig();
        generatorConfig.setDbHost("localhost");
        generatorConfig.setDbName("fast-family-example");
        generatorConfig.setDbPassword("root");
        generatorConfig.setDbUser("root");
        generatorConfig.setPort(3306);
        generatorConfig.setPackageName("com.fast.family.example");
        generatorConfig.setSrcBasePath("src//main//java//com//fast//family//example//");
        return generatorConfig;
    }
}

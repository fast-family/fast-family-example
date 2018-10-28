package com.fast.family.mvc.example.controller;

import com.fast.family.log.LogConstant;
import com.fast.family.log.annotation.LogAnnotation;
import com.fast.family.mvc.generic.controller.GenericController;
import com.fast.family.mvc.generic.service.GenericService;
import com.fast.family.mvc.example.entity.SysUser;
import com.fast.family.mvc.example.service.SysUserService;


import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
* 描述: 用户信息控制器
* <p>
*
* @created 2018-10-07 10:57:49
*/
@RestController
@RequestMapping("user")
@Slf4j
@Api(tags = "用户信息接口")
public class SysUserController extends GenericController<SysUser,Long>{

    @Autowired
    private SysUserService sysUserService;

    @LogAnnotation(methodName = "helloword",methodType = LogConstant.SELECT,desc = "helloword")
    @GetMapping("/helloword")
    public String helloword(String name){
        return "helloword";
    }


    @Override
    public GenericService<SysUser, Long> getService() {
        return this.sysUserService;
    }
}
package com.fast.family.example.controller;

import com.fast.family.example.entity.UserEntity;
import com.fast.family.example.service.UserService;
import com.github.zs.lqh.springmvc.common.controller.GenericController;
import com.github.zs.lqh.springmvc.common.service.GenericService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 张顺
 * @version 1.0
 * @created 2018/9/19-21:53
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户")
public class UserController extends GenericController<UserEntity,Long>{

    @Autowired
    private UserService userService;

    @Override
    public GenericService<UserEntity, Long> getService() {
        return this.userService;
    }
}

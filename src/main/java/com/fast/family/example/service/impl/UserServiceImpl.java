package com.fast.family.example.service.impl;

import com.fast.family.example.entity.UserEntity;
import com.fast.family.example.mapper.UserMapper;
import com.fast.family.example.service.UserService;
import com.github.zs.lqh.mapper.BaseMapper;
import com.github.zs.lqh.springmvc.common.service.impl.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 张顺
 * @version 1.0
 * @created 2018/9/19-21:52
 */
@Service
public class UserServiceImpl extends GenericServiceImpl<UserEntity,Long>
    implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public BaseMapper<UserEntity> getMapper() {
        return userMapper;
    }
}

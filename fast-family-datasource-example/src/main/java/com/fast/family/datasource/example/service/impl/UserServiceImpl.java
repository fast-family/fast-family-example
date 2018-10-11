package com.fast.family.datasource.example.service.impl;

import com.fast.family.datasource.annotation.DataSourceAnnotation;
import com.fast.family.datasource.example.entity.User;
import com.fast.family.datasource.example.mapper.UserDao;
import com.fast.family.datasource.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 张顺
 * @version 1.0
 * @created 2018/10/7-21:21
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @DataSourceAnnotation(name = "slave_0")
    @Override
    public List<User> selectAlldb1() {
        return userDao.selectAll();
    }

    @DataSourceAnnotation(name = "master")
    @Override
    public List<User> selectAlldb2() {
        return userDao.selectAll();
    }

    @DataSourceAnnotation(name = "slave_0")
    @Override
    public void savedb1() {
        if (true){
            throw new RuntimeException("异常了");
        }
    }

    @DataSourceAnnotation(name = "master")
    @Override
    public void savedb2() {
        User user = new User();
        user.setPassword("1231");
        user.setUsername("1231232");
        userDao.insert(user);
    }
}

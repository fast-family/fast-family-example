package com.fast.family.datasource.example.service;

import com.fast.family.datasource.annotation.DataSourceAnnotation;
import com.fast.family.datasource.example.entity.User;

import java.util.List;

/**
 * @author 张顺
 * @version 1.0
 * @created 2018/10/7-21:21
 */
public interface UserService {

    List<User> selectAlldb1();

    List<User> selectAlldb2();

    void savedb1();

    void savedb2();
}

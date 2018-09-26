package com.fast.family.example;

import com.fast.family.example.entity.UserEntity;
import com.fast.family.utils.GsonUtils;

/**
 * @author 张顺
 * @version 1.0
 * @created 2018/9/22-15:27
 */
public class GsonTest {

    public static void main(String[] args) {
        UserEntity userEntity = new UserEntity();
        userEntity.setPassword("1231");
        userEntity.setUsername("12312");
        String json = GsonUtils.toJson(userEntity,UserEntity.class);
        System.out.println("对象转换json"+json);
        UserEntity toJson = GsonUtils.fromJson(json,UserEntity.class);
        System.out.println("json转对象："+toJson.getPassword());
    }
}

package com.fast.family.example;

import com.fast.family.example.dto.UserDto;
import com.fast.family.example.entity.UserEntity;

/**
 * @author 张顺
 * @version 1.0
 * @created 2018/9/22-14:38
 */
public class UserDtoTest {

    public static void main(String[] args) {

        UserDto userDto = new UserDto("sss","2222");
        UserEntity userEntity = userDto.convertTo();
        System.out.println("转换成功？？" + userEntity.toString());
    }
}

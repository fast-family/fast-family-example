package com.fast.family.example.dto;

import com.fast.family.example.entity.UserEntity;
import com.fast.family.mvc.generic.service.domain.AbstractPersistableBusinessObject;
import com.fast.family.mvc.generic.service.domain.AbstractPersistableBusinessObjectAdapter;
import lombok.Data;

/**
 * @author 张顺
 * @version 1.0
 * @created 2018/9/22-14:35
 */
@Data
public class UserDto extends AbstractPersistableBusinessObjectAdapter<UserEntity> {

    private String username;

    private String sex;

    public UserDto(){
        super(UserEntity.class);
    }

    public UserDto( String username, String sex) {
        this();
        this.username = username;
        this.sex = sex;
    }

    public UserDto(Class<UserEntity> persistableEntityClass) {
        super(persistableEntityClass);
    }

    @Override
    protected void customizeConvert(UserEntity userEntity) {
        userEntity.setPassword(sex);
    }

    @Override
    protected void customizeFill(UserEntity userEntity) {
        sex = userEntity.getUsername();
    }
}

package com.fast.family.example.entity;

import com.fast.family.mvc.generic.entity.GenericEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author 张顺
 * @version 1.0
 * @created 2018/9/19-21:49
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "sys_user")
public class UserEntity extends GenericEntity<Long> {


    @Column(name = "user_name")
    private String username;

    @Column(name = "password")
    private String password;
}

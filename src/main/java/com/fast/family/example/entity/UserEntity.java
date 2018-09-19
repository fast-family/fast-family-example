package com.fast.family.example.entity;

import com.github.zs.lqh.mapper.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class UserEntity extends BaseEntity<Long>{


    private String username;

    private String password;
}

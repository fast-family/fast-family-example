package com.fast.family.security.example.entity;

import com.fast.family.mvc.generic.entity.GenericEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
* <p>
* 描述: 用户信息实体
* <p>
* @created 2018-10-07 10:57:50
*/
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sys_user")
@ApiModel(value = "用户信息实体")
public class SysUser extends GenericEntity<Long> {




    @Column(name = "user_name")
    @ApiModelProperty(required = true, dataType = "String", name = "")
    private String userName;


    @Column(name = "password")
    @ApiModelProperty(required = true, dataType = "String", name = "")
    private String password;





}
package com.fast.family.security.example.dto;


import com.fast.family.mvc.generic.service.domain.AbstractPersistableBusinessObjectAdapter;
import com.fast.family.security.example.entity.SysUser;


/**
* <p>
* 描述: 用户信息Dto实体
* <p>
*
* @created 2018-10-07 10:57:50
*/
public class SysUserDTO extends AbstractPersistableBusinessObjectAdapter<SysUser>{


    public SysUserDTO(Class<SysUser> persistableEntityClass) {
        super(persistableEntityClass);
    }

    @Override
    protected void customizeConvert(SysUser sysUser) {

    }

    @Override
    protected void customizeFill(SysUser sysUser) {

    }
}

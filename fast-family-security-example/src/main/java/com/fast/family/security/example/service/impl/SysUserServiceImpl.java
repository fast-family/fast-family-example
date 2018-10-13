package com.fast.family.security.example.service.impl;



import com.fast.family.mvc.generic.mapper.GenericMapper;
import com.fast.family.mvc.generic.service.impl.GenericServiceImpl;
import com.fast.family.security.example.entity.SysUser;
import com.fast.family.security.example.mapper.SysUserMapper;
import com.fast.family.security.example.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
* <p>
* 描述: 用户信息业务实现类
* <p>
*
* @created 2018-10-07 10:57:49
*/
@Service
@Slf4j
public class SysUserServiceImpl extends GenericServiceImpl<SysUser,Long> implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;


    @Override
    public GenericMapper<SysUser, Long> getMapper() {
        return sysUserMapper;
    }
}
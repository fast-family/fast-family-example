package com.fast.family.example.security;

import com.fast.family.example.entity.UserEntity;
import com.fast.family.example.mapper.UserMapper;
import com.fast.family.utils.ArrayUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

/**
 * @author 张顺
 * @version 1.0
 * @created 2018/9/24-13:19
 */
@Component
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Example example = new Example(UserEntity.class);
        example.createCriteria().andEqualTo("username",username);
        UserEntity userEntity = userMapper.selectOneByExample(example);
        return new User(userEntity.getUsername(),userEntity.getPassword(),
                AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN"));
    }

}

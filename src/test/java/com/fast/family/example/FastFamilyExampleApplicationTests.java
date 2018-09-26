package com.fast.family.example;

import com.fast.family.example.entity.UserEntity;
import com.fast.family.example.mapper.UserMapper;
import com.fast.family.example.service.UserService;

import com.google.common.eventbus.EventBus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class FastFamilyExampleApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void contextLoads() {



		UserEntity userEntity = new UserEntity();
		userEntity.setPassword("222");
		userEntity.setUsername("12312");
		this.userMapper.insert(userEntity);
	}

}

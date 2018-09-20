package com.fast.family.example;

import com.fast.family.example.entity.UserEntity;
import com.fast.family.example.mapper.UserMapper;
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
		userEntity.setId(1l);
		userEntity.setPassword("12312");
		userEntity.setUsername("12414");
		userMapper.insert(userEntity);

	}

}

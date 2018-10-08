package com.fast.family.datasource.example;

import com.fast.family.datasource.example.mapper.UserDao;
import com.fast.family.datasource.example.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FastFamilyDatasourceExampleApplicationTests {

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserService userService;

	@Test
	public void contextLoads() {
		System.out.println("查询数据大小："+userService.selectAlldb1().size());
		System.out.println("查询数据大小："+userService.selectAlldb2().size());

	}

}

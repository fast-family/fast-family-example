package com.fast.family.datasource.example;

import com.fast.family.datasource.example.mapper.UserDao;
import com.fast.family.datasource.example.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FastFamilyDatasourceExampleApplicationTests {


	@Autowired
	private UserService userService;



	@Transactional
	@Test
	public void saveTest(){
		userService.savedb2();
		userService.savedb1();
	}

}

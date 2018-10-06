package com.fast.family.mvc.example;

import com.fast.family.mvc.example.entity.SysUser;
import com.fast.family.mvc.example.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FastFamilyMvcExampleApplicationTests {

	@Autowired
	private SysUserService sysUserService;

	@Test
	public void contextLoads() {
		SysUser sysUser = sysUserService.selectById(Long.valueOf("1043353933620113408")).get();
		System.out.println("查询信息:"+sysUser.getUserName());
	}

}

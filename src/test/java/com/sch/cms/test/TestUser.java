package com.sch.cms.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sch.entity.User;
import com.sch.service.UserService;

/**
 * 
 * @宋春浩
 *
 * 2019年10月17日
 */
public class TestUser extends BateTest{

	@Autowired
	UserService userService;
	
	@Test
	public void testRegister() {
		User user = new User("zhang","password",1);
		int register = userService.register(user);
		System.out.println(register);
		//assertTrue(register > 0);
	}
	
	
	
}

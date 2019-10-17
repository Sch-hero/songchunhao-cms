package com.sch.service;

import com.sch.entity.User;

public interface UserService {

	boolean checkUserExist(String username);
	
	int register(User user);

	User login(User user);


}

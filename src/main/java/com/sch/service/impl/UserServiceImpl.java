package com.sch.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sch.dao.UserMapper;
import com.sch.entity.User;
import com.sch.service.UserService;
import com.sch.utils.Md5Utils;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	
	@Override
	public boolean checkUserExist(String username) {
		// TODO Auto-generated method stub
		
		return null != userMapper.findByName(username);
	}

	@Override
	public int register(User user) {
		// TODO Auto-generated method stub
		User exisUser = userMapper.findByName(user.getUsername());
		if (exisUser!=null) {
			return -1;//用户已存在
		}
		//user.setPasswrod(Md5Utils.md5(user.getUsername(),user.getPasswrod()));
		return userMapper.add(user);
	}

	
	//登录
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		String pwdStr = Md5Utils.md5(user.getPassword(), user.getUsername());
		User loginUser = userMapper.findByName(user.getUsername());
		if (loginUser!=null && pwdStr.equals(loginUser.getPassword())) {
			return loginUser;
		}
		return null;
	}
}

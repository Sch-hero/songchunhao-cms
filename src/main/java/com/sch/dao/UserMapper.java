package com.sch.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.sch.entity.User;

public interface UserMapper {

	//添加(注册)
	@Insert("insert into cms_user (username,password,create_time) values (#{username},#{password},#{create_time})")
	int add(User user);

	@Select("select id,username,password from cms_user where username=#{value} limit 1")
	User findByName(String username);
}

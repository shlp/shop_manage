package com.user.dao;

import java.util.List;
import com.entity.Users;


/**
 * 
 * 用户DAO接口
 * 
 * */
public interface UserDao {

	//查询用户
	//public List<Users> login(Users u);//登录
	public Users findUser(Users u);
	Users findById(int userId);
	void updateUser(Users user);
	
}

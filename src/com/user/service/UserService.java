package com.user.service;

import java.util.List;
import com.entity.Users;

/**
 * 	用户业务层接口
 * 
 * */
public interface UserService {

	//登录
	//public List<Users> login(Users u);
	Users login(Users user);
	Users findById(int userId);
	void  updateUser(Users user);
}

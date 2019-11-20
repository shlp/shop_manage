package com.user.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.entity.Users;
import com.user.dao.UserDao;

/**
 * 用户业务层实现类
 * 
 * */
public class UserServiceImpl implements UserService{
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public Users login(Users user) {
		//System.out.println("UserServiceImp");
		Users existuser=userDao.findUser(user);
		return existuser;
	}
	
	@Override
	public Users findById(int userId) {
		return userDao.findById(userId);
	}

	@Override
	public void updateUser(Users user) {
		Users u=(Users)userDao.findById(user.getUserId());
		u.setUserName(user.getUserName());
		u.setUserPassword(user.getUserPassword());
		u.setUserImage(user.getUserImage());
		userDao.updateUser(u);
	}




}

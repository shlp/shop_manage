package com.user.dao;

import java.util.List;
import com.entity.Users;


/**
 * 
 * �û�DAO�ӿ�
 * 
 * */
public interface UserDao {

	//��ѯ�û�
	//public List<Users> login(Users u);//��¼
	public Users findUser(Users u);
	Users findById(int userId);
	void updateUser(Users user);
	
}
